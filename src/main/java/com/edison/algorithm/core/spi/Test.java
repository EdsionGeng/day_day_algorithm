package com.edison.algorithm.core.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Description SPI 测试
 * @Date 2020/3/8上午11:29
 * @Created by edsiongeng
 */
public class Test {

    public static void main(String[] args) {
        ServiceLoader<Fruit> s = ServiceLoader.load(Fruit.class);
        Iterator<Fruit> it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getName());
        }
    }
}
