package com.edison.algorithm.pattern.flyweight;

/**
 * @Description TODO
 * @Date 2020/3/21上午11:55
 * @Created by edsiongeng
 */
public abstract class IgoChessman {
    public abstract String getColor();

    public void display(Coordinates coordinates) {
        System.out.println("Chess color is:" + this.getColor() + ",location=" + coordinates.getX() + "," + coordinates.getY());
    }


}
