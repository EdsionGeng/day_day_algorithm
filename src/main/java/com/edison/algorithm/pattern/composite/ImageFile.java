package com.edison.algorithm.pattern.composite;

/**
 * @Description TODO
 * @Date 2020/3/13下午11:01
 * @Created by edsiongeng
 */
public class ImageFile extends AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("unsupported method");

    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("unsupported method");

    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("unsupprted method");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("to image"+name+" kill virus");
    }
}
