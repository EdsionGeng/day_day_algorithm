package com.edison.algorithm.core.io.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * 描述:
 * 业务线程
 *
 * @author gengyongchang
 * @create 2021-02-04 15:48
 */
public class Handler implements Runnable {
    private static final byte[] b = "hello,server received your message".getBytes();

    private SocketChannel sc;
    private ByteBuffer byteBuffer;
    private SubReactorThread parent;

    public Handler(SocketChannel sc, ByteBuffer byteBuffer, SubReactorThread subReactorThread) {
        this.sc = sc;
        this.byteBuffer = byteBuffer;
        this.parent = subReactorThread;
    }

    @Override
    public void run() {
        System.out.println("业务在handler开始执行、、、");

        byteBuffer.put(b);
        parent.register(new NioTask(sc, SelectionKey.OP_WRITE, byteBuffer));
        System.out.println("业务在handler执行结束！");
    }
}