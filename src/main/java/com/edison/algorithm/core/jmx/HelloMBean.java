package com.edison.algorithm.core.jmx;

/**
 * @Description TODO
 * @Date 2020/3/14下午4:01
 * @Created by edsiongeng
 */
public interface HelloMBean {
    public String getName();

    public void setName(String name);

    public String getAge();

    public void setAge(String age);

    public void helloWorld();

    public void helloWorld(String str);

    public void getTelephone();

}
