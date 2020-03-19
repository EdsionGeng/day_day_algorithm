package com.edison.algorithm.pattern.strategy;

/**
 * @Description TODO
 * @Date 2020/3/10下午11:18
 * @Created by edsiongeng
 */
public class ChildrenDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("Children ticket:");
        return price - 10;
    }
}
