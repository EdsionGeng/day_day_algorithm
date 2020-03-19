package com.edison.algorithm.pattern.composite;

/**
 * @Description TODO
 * @Date 2020/3/13下午10:59
 * @Created by edsiongeng
 */
public abstract class AbstractFile {

    public abstract void add(AbstractFile file);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile getChild(int i);

    public abstract void killVirus();

}
