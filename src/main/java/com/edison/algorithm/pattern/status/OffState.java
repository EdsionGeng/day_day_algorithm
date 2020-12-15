package com.edison.algorithm.pattern.status;

/**
 * @Description TODO
 * @Date 2020/3/11上午12:34
 * @Created by edsiongeng
 */
public class OffState  extends State{
    @Override
    public void on(Switch s) {
        System.out.println("打开");
        s.setState(Switch.getState("on"));
    }

    @Override
    public void off(Switch s) {
        System.out.println("已经关闭");
    }
}
