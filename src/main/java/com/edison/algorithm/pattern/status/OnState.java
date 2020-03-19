package com.edison.algorithm.pattern.status;

/**
 * @Description TODO
 * @Date 2020/3/11上午12:32
 * @Created by edsiongeng
 */
public class OnState  extends State{

    @Override
    public void on(Switch s) {
        System.out.println("已经打开");
    }

    @Override
    public void off(Switch s) {
        System.out.println("关闭！");
        s.setState(Switch.getState("off"));

    }
}
