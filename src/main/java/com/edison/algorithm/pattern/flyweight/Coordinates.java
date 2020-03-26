package com.edison.algorithm.pattern.flyweight;

/**
 * @Description TODO
 * @Date 2020/3/21下午12:12
 * @Created by edsiongeng
 */
public class Coordinates {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
