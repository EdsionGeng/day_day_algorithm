package com.edison.algorithm.algorithm;

import java.util.Iterator;

/**
 * @Description TODO
 * @Date 2020/7/12下午6:27
 * @Created by edsiongeng
 */
public abstract class ST<Key, Value> {

    public abstract void put(Key key, Value value);

    public abstract Value get(Key key);

    public abstract boolean contains(Key key);

    public abstract boolean isEmpty();

    public abstract int size();

    public abstract Iterator<Key> keys();
}
