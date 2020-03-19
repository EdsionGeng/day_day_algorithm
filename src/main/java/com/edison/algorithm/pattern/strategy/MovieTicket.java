package com.edison.algorithm.pattern.strategy;

/**
 * @Description 电影票：环境类
 * @Date 2020/3/10下午11:13
 * @Created by edsiongeng
 */
public class MovieTicket {

    private double price;
    private Discount discount;

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return discount.calculate(this.price);
    }
}
