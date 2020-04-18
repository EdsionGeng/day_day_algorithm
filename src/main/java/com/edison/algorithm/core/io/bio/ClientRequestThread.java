package com.edison.algorithm.core.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Date 2020/4/16上午12:40
 * @Created by edsiongeng
 */
public class ClientRequestThread implements Runnable {
    private CountDownLatch countDownLatch;
    private Integer clientIndex;

    public ClientRequestThread(CountDownLatch countDownLatch, Integer clientIndex) {
        this.countDownLatch = countDownLatch;
        this.clientIndex = clientIndex;
    }

    @Override
    public void run() {
        Socket socket = null;
        OutputStream clientRequest = null;
        InputStream clientResponse = null;
        try {
            socket = new Socket("localhost", 8083);
            clientRequest = socket.getOutputStream();
            clientResponse = socket.getInputStream();
            //等待，直到SocketClientDaemon完成所有线程的启动，然后所有线程一起发送请求
            this.countDownLatch.await();

            clientRequest.write(("This  is " + this.clientIndex + " client request,over").getBytes());
            clientRequest.flush();

            System.out.println(this.clientIndex + " client finish request,wait from server info");

            int maxLen = 1024;
            byte[] contextBytes = new byte[maxLen];
            int reallen;
            String message = "";
            while ((reallen = clientResponse.read(contextBytes, 0, maxLen)) != -1) {
                message += new String(contextBytes, 0, reallen);
            }
            message = URLDecoder.decode(message, "UTF-8");
            System.out.println(this.clientIndex + " client receive server info" + message);
        } catch (Exception e) {

        }finally {
            try {
                if(clientRequest != null) {
                    clientRequest.close();
                }
                if(clientResponse != null) {
                    clientResponse.close();
                }
            } catch (IOException e) {

            }
        }

    }
}
