package com.edison.algorithm.pattern.template;

/**
 * @Description TODO
 * @Date 2020/3/22下午10:40
 * @Created by edsiongeng
 */
public class Client {
    public static void main(String[] args) {
        Account account = new SavingAccount();
        account.handle("edison","123456");
    }
}
