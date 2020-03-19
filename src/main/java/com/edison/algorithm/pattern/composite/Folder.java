package com.edison.algorithm.pattern.composite;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Date 2020/3/13下午11:05
 * @Created by edsiongeng
 */
public class Folder extends AbstractFile {

    private ArrayList<AbstractFile> fileList = new ArrayList<>();
    private String name;

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        fileList.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        fileList.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("To folder"+name+" kill virus");
        for (AbstractFile abstractFile:fileList) {
            abstractFile.killVirus();
        }
    }
}
