package com.edison.algorithm.core.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description TODO
 * @Date 2020/4/16上午12:25
 * @Created by edsiongeng
 */
public class BioSocketServer {
    private static int DEFAULT_PORT = 8083;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Listen from " + DEFAULT_PORT + " port info");
            serverSocket = new ServerSocket(DEFAULT_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                SocketServerThread socketServerThread = new SocketServerThread(socket);
                new Thread(socketServerThread).start();
            }


        } catch (Exception e) {

        }finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (BioSocketServer.class){
            try {
                BioSocketServer.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
