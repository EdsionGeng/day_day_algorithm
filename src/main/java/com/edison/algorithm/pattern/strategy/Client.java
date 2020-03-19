package com.edison.algorithm.pattern.strategy;

/**
 * @Description TODO
 * @Date 2020/3/10下午11:28
 * @Created by edsiongeng
 */
public class Client {
    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket();
        double orginalPrice = 60;
        double currentPrice;
        mt.setPrice(orginalPrice);
        System.out.println("orginal price:" + orginalPrice);

        Discount discount = (Discount) XmlUtil.getBean();
        mt.setDiscount(discount);
        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
    }
}
