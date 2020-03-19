package com.edison.algorithm.pattern.strategy;

/**
 * @Description TODO
 * @Date 2020/3/10下午11:17
 * @Created by edsiongeng
 */
public class StudentDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("Student ticket");
        return price * 0.8;
    }
}
