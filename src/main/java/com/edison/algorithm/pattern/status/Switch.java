package com.edison.algorithm.pattern.status;

/**
 * @Description 在有些情况下，多个环境对象可能需要共享同一个状态，
 * 如果希望在系统中实现多个环境对象共享一个或多个状态对象，那么需要将这些状态对象定义为环境类的静态成员对象。
 * @Date 2020/3/11上午12:29
 * @Created by edsiongeng
 */
public class Switch {
    private static State state, onState, offState;
    private String name;

    public Switch(String name) {
        this.name = name;
        onState = new OnState();
        offState = new OffState();
        this.state = new OnState();

    }

    public void setState(State state) {
        this.state = state;
    }

    public static State getState(String type) {
        if (type.equalsIgnoreCase("on")) {
            return onState;
        } else {
            return offState;
        }
    }

    public void on() {
        System.out.println(name);
        state.on(this);
    }

    public void off() {
        System.out.println(name);
        state.off(this);
    }
}
