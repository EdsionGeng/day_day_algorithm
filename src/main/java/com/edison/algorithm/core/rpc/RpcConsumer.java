package com.edison.algorithm.core.rpc;

/**
 * @Description TODO
 * @Date 2020/3/29下午5:21
 * @Created by edsiongeng
 */
public class RpcConsumer {
    public static void main(String[] args) throws Exception {

        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 8080);
        System.out.println(Integer.MIN_VALUE);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String hello = service.hello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }

    }
}
