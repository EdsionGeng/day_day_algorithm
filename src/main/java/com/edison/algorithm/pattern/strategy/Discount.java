package com.edison.algorithm.pattern.strategy;

/**
 * @Description 折扣类：抽象策略类
 * @Date 2020/3/10下午11:12
 * @Created by edsiongeng
 */
public interface Discount {

    public double calculate(double price);
}
