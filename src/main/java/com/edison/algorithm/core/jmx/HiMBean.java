package com.edison.algorithm.core.jmx;

/**
 * @Description TODO
 * @Date 2020/3/14下午4:31
 * @Created by edsiongeng
 */
public interface HiMBean {

    public String getName();

    public void setName(String name);

    public void printHello();

    public void printHello(String whoName);
}
