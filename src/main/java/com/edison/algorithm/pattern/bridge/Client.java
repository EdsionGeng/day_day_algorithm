package com.edison.algorithm.pattern.bridge;

/**
 * @Description TODO
 * @Date 2020/3/13下午4:14
 * @Created by edsiongeng
 */
public class Client {

    public static void main(String[] args) {
        Image image = new JPGImage();
        ImageImp imageImp = new LinuxImp();
        image.setImageImp(imageImp);
        image.parseFile("小龙女");
    }
}
