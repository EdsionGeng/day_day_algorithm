package com.edison.algorithm.pattern.bridge;

/**
 * @Description JPG :扩充抽象类
 * @Date 2020/3/13下午3:59
 * @Created by edsiongeng
 */
public class JPGImage extends Image {
    @Override
    public void parseFile(String fileName) {
        Martix m = new Martix();
        imp.doPaint(m);
        System.out.println(fileName+",格式为JPG");
    }
}
