package com.edison.algorithm.core.io.nio;

import java.io.IOException;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 描述:
 * 处理连接请求的反应堆
 *
 * @author gengyongchang
 * @create 2021-02-04 15:20
 */
public class MainReactor implements Runnable {
    private Selector selector;
    private SubReactorThreadGroup subReactorThreadGroup;

    public MainReactor(SelectableChannel channel) {
        try {
            selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        subReactorThreadGroup = new SubReactorThreadGroup(4);
    }

    @Override
    public void run() {
        System.out.println("MainReactor is running");
        while (!Thread.interrupted()) {
            Set<SelectionKey> ops = null;
            try {
                selector.select(1000);
                ops = selector.selectedKeys();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator<SelectionKey> iterator = ops.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                try {
                    if (key.isAcceptable()) {
                        System.out.println("Receive request from client...");
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                        SocketChannel clientChannel = serverSocketChannel.accept();
                        clientChannel.configureBlocking(false);
                        subReactorThreadGroup.dispatch(clientChannel);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("客户端主动断开连接");
                }
            }
        }
    }
}