package com.edison.algorithm.pattern.decorater;

/**
 * @Description TODO
 * @Date 2020/3/15上午9:59
 * @Created by edsiongeng
 */
public class Client {

    public static void main(String[] args) {
        Component component, componentSB;
        component = new Window();
        componentSB = new ScrollBarDecorator(component);
        componentSB.display();
    }
}
