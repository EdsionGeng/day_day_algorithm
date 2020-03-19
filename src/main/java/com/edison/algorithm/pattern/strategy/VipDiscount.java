package com.edison.algorithm.pattern.strategy;

/**
 * @Description TODO
 * @Date 2020/3/10下午11:19
 * @Created by edsiongeng
 */
public class VipDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("VIP ticket:");
        System.out.println("Add coin");
        return price * 0.5;
    }
}
