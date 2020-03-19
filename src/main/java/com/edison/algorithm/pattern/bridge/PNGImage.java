package com.edison.algorithm.pattern.bridge;

/**
 * @Description TODO
 * @Date 2020/3/13下午4:01
 * @Created by edsiongeng
 */
public class PNGImage extends Image {
    @Override
    public void parseFile(String fileName) {
        Martix m = new Martix();
        imp.doPaint(m);
        System.out.println(fileName+",格式为PNG");

    }
}
