package com.edison.algorithm.core.rpc;

/**
 * @Description TODO
 * @Date 2020/3/29下午5:19
 * @Created by edsiongeng
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello" + name;
    }
}
