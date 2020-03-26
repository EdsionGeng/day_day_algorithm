package com.edison.algorithm.pattern.template;

/**
 * @Description TODO
 * @Date 2020/3/22下午10:34
 * @Created by edsiongeng
 */
public abstract class Account {
    public boolean validate(String account, String password) {
        if (account.equalsIgnoreCase("edison") &&
                password.equalsIgnoreCase("123456")) {
            return true;
        }
        return false;
    }

    public abstract void calculateInterest();

    public void display() {
        System.out.println("display interest");
    }

    public void handle(String account, String password) {
        if (!validate(account, password)) {
            System.out.println("account error");
            return;
        }
        calculateInterest();
        display();
    }
}
