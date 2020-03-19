package com.edison.algorithm.pattern.bridge;

/**
 * @Description 抽象图像类
 * @Date 2020/3/13下午3:54
 * @Created by edsiongeng
 */
public abstract class Image {
    protected ImageImp imp;

    public void setImageImp(ImageImp imp) {
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);
}
