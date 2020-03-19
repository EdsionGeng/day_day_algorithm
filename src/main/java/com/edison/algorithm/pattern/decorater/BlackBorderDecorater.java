package com.edison.algorithm.pattern.decorater;

/**
 * @Description TODO
 * @Date 2020/3/15上午9:57
 * @Created by edsiongeng
 */
public class BlackBorderDecorater extends ComponentDecorater {


    public BlackBorderDecorater(Component component) {
        super(component);
    }

    public void display() {
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder(){
        System.out.println("为构件增加黑色边框");
    }
}
