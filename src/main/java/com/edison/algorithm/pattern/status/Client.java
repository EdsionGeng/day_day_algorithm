package com.edison.algorithm.pattern.status;

/**
 * @Description TODO
 * @Date 2020/3/11上午12:12
 * @Created by edsiongeng
 */
public class Client {
    public static void main(String[] args) {
        Account account = new Account("EdisonGeng", 0.0);
        account.deposit(1000);
        account.withdraw(2000);
        account.deposit(3000);
        account.withdraw(4000);
        account.withdraw(1000);
        account.computeInterest();
    }
}
