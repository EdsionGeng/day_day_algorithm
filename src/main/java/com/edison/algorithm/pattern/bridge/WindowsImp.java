package com.edison.algorithm.pattern.bridge;

/**
 * @Description TODO
 * @Date 2020/3/13下午3:55
 * @Created by edsiongeng
 */
public class WindowsImp implements ImageImp {
    @Override
    public void doPaint(Martix m) {
        System.out.println("Windows display image");
    }
}
