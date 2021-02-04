package com.edison.algorithm.core.io.nio;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 * NIO线程组
 *
 * @author gengyc
 * @create 2021-02-04 15:23
 */
public class SubReactorThreadGroup {
    //请求计数器
    private static final AtomicInteger requestCounter = new AtomicInteger();
    private final int nioThreadCount;
    private static final int DEFAULT_NIO_THREAD_COUNT = 4;
    private SubReactorThread[] nioThreads;
    private ExecutorService businessExecutePool;

    public SubReactorThreadGroup() {
        this(DEFAULT_NIO_THREAD_COUNT);
    }

    public SubReactorThreadGroup(int threadCount) {
        if (threadCount < 1) {
            threadCount = DEFAULT_NIO_THREAD_COUNT;
        }
        businessExecutePool = Executors.newFixedThreadPool(threadCount);
        this.nioThreadCount = threadCount;
        this.nioThreads = new SubReactorThread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            this.nioThreads[i] = new SubReactorThread(businessExecutePool);
            this.nioThreads[i].start();
        }
        System.out.println("线程数量 " + threadCount);

    }

    public void dispatch(SocketChannel socketChannel) {
        if (socketChannel != null) {
            next().register(new NioTask(socketChannel, SelectionKey.OP_READ));
        }
    }

    public SubReactorThread next() {
        return this.nioThreads[requestCounter.getAndIncrement() % nioThreadCount];
    }

}