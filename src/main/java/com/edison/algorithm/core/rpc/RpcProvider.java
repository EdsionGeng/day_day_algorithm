package com.edison.algorithm.core.rpc;

/**
 * @Description TODO
 * @Date 2020/3/29下午5:19
 * @Created by edsiongeng
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception{
        HelloService service=new HelloServiceImpl();
        RpcFramework.export(service,8080);
    }
}
