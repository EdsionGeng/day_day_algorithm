package com.edison.algorithm.core.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:
 * 主从Reactor模式实现
 *
 * @author gengyongchang
 * @create 2021-02-04 15:15
 */
public class NioServer {
    private static final int DEFAULT_PORT = 9080;

    public static void main(String[] args) {
        new Thread(new Acceptor()).start();
    }

    private static class Acceptor implements Runnable {
        private static ExecutorService mainReactor = Executors.newSingleThreadExecutor();

        @Override
        public void run() {
            ServerSocketChannel ssc = null;
            try {
                ssc = ServerSocketChannel.open();
                ssc.configureBlocking(false);
                ssc.bind(new InetSocketAddress(DEFAULT_PORT));
                dispatch(ssc);
                System.out.println("Server start success!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void dispatch(ServerSocketChannel ssc) {
            mainReactor.submit(new MainReactor(ssc));
        }
    }


}