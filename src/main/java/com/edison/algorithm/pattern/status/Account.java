package com.edison.algorithm.pattern.status;

/**
 * @Description 银行账户：环境类
 * @Date 2020/3/10下午11:45
 * @Created by edsiongeng
 */
public class Account {

    private AccountState state;
    private String owner;
    private double balance = 0;


    public Account(String owner, double init) {
        this.owner = owner;
        this.balance = init;
        this.state = new NormalState(this);
        System.out.println(this.owner + "开户，初始金额为" + init);
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public void deposit(double amount) {
        System.out.println(this.owner + "存款" + amount);
        state.deposit(amount); //调用状态对象的deposit()方法
        System.out.println("现在余额为"+ this.balance);
        System.out.println("现在帐户状态为"+ this.state.getClass().getName());
        System.out.println("---------------------------------------------");
    }

    public void withdraw(double amount) {
        System.out.println(this.owner + "取款" + amount);
        state.withdraw(amount); //调用状态对象的withdraw()方法
        System.out.println("现在余额为"+ this.balance);
        System.out.println("现在帐户状态为"+ this. state.getClass().getName());
        System.out.println("---------------------------------------------");
    }

    public void computeInterest() {
        state.computeInterest();
    }
}
