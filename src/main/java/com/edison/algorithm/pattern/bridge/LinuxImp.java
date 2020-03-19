package com.edison.algorithm.pattern.bridge;

/**
 * @Description Linux
 * @Date 2020/3/13下午3:58
 * @Created by edsiongeng
 */
public class LinuxImp implements ImageImp {
    @Override
    public void doPaint(Martix m) {
        System.out.println("Linux display image");
    }
}
