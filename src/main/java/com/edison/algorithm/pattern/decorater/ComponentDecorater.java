package com.edison.algorithm.pattern.decorater;

/**
 * @Description TODO
 * @Date 2020/3/15上午9:54
 * @Created by edsiongeng
 */
public class ComponentDecorater extends Component {
    private Component component;


    public ComponentDecorater(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
