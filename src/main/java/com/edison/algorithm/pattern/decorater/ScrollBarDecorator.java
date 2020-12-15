package com.edison.algorithm.pattern.decorater;

/**
 * @Description TODO
 * @Date 2020/3/15上午9:55
 * @Created by edsiongeng
 */
public class ScrollBarDecorator extends ComponentDecorator {

    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        this.setScrollBar();
        super.display();
    }

    public void setScrollBar() {
        System.out.println("为构件增加滚动条");
    }
}
