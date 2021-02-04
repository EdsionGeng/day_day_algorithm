package com.edison.algorithm.core.io.nio;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 * Nio线程，专门负责 read,write
 *
 * @author gengyongchang
 * @create 2021-02-04 15:27
 */
public class SubReactorThread extends Thread {
    private Selector selector;
    private ExecutorService businessExecutePool;
    private List<NioTask> taskList = new ArrayList<>(512);
    private ReentrantLock taskMainLock = new ReentrantLock();

    public SubReactorThread(ExecutorService businessExecutePool) {
        try {
            this.businessExecutePool = businessExecutePool;
            this.selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void register(NioTask nioTask) {
        if (nioTask != null) {
            try {
                taskMainLock.lock();
                taskList.add(nioTask);
            } finally {
                taskMainLock.unlock();
            }
        }
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            Set<SelectionKey> ops = null;
            try {
                selector.select(1000);
                ops = selector.selectedKeys();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }


            for (Iterator<SelectionKey> it = ops.iterator(); it.hasNext(); ) {
                SelectionKey key = it.next();
                it.remove();

                try {
                    if (key.isWritable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buf = (ByteBuffer) key.attachment();
                        buf.flip();
                        clientChannel.write(buf);
                        System.out.println("Server send data to client ...");
                        clientChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        System.out.println("Server receive request from client...");
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        System.out.println(buffer.capacity());
                        clientChannel.read(buffer);

                        dispatch(clientChannel, buffer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("客户端主动断开连接");
                }
            }

        }
        if (CollectionUtils.isNotEmpty(taskList)) {
            try {
                taskMainLock.lock();
                for (Iterator<NioTask> it = taskList.iterator(); it.hasNext(); ) {
                    NioTask task = it.next();
                    SocketChannel sc = task.getSc();
                    if (task.getData() != null) {
                        sc.register(selector, task.getOp(), task.getData());
                    } else {
                        sc.register(selector, task.getOp());
                    }
                    it.remove();
                }
            } catch (ClosedChannelException e) {
                e.printStackTrace();
            } finally {
                taskMainLock.unlock();
            }
        }

    }

    private void dispatch(SocketChannel sc, ByteBuffer byteBuffer) {
        businessExecutePool.submit(new Handler(sc, byteBuffer, this));
    }
}