package com.edison.algorithm.pattern.status;

/**
 * @Description  抽象状态类
 * @Date 2020/3/10下午11:47
 * @Created by edsiongeng
 */
public abstract class AccountState {
    protected Account acc;

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void computeInterest();

    public abstract void stateCheck();
}
