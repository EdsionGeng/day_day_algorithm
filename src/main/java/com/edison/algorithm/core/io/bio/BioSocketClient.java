package com.edison.algorithm.core.io.bio;

import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Date 2020/4/16上午12:37
 * @Created by edsiongeng
 */
public class BioSocketClient {
    public static void main(String[] args) {
        Integer clientNumber = 20;
        CountDownLatch countDownLatch = new CountDownLatch(clientNumber);

        for (int i = 0; i < clientNumber; i++, countDownLatch.countDown()){
            ClientRequestThread client = new ClientRequestThread(countDownLatch, i);
            client.run();
        }
        synchronized (BioSocketClient.class){
            try {
                BioSocketClient.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
