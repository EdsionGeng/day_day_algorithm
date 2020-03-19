package com.edison.algorithm.core.jmx;

/**
 * @Description TODO
 * @Date 2020/3/14下午4:32
 * @Created by edsiongeng
 */
public class Hi implements HiMBean {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printHello() {
        System.out.println("Hello World" + name);

    }

    @Override
    public void printHello(String whoName) {
        System.out.println("HelloWOrld" + whoName);
    }
}
