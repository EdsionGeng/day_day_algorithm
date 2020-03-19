package com.edison.algorithm.pattern.status;

/**
 * @Description TODO
 * @Date 2020/3/11上午12:31
 * @Created by edsiongeng
 */
public abstract class State {

    public abstract void on(Switch s);

    public abstract void off(Switch s);
}
