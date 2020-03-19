package com.edison.algorithm.pattern.status;

/**
 * @Description 正常状态
 * @Date 2020/3/10下午11:55
 * @Created by edsiongeng
 */
public class NormalState extends AccountState {

    public NormalState(AccountState state) {
        this.acc = state.acc;
    }

    public NormalState(Account acc) {
        this.acc = acc;
    }


    @Override
    public void deposit(double amount) {
        acc.setBalance(acc.getBalance() + amount);
        stateCheck();

    }

    @Override
    public void withdraw(double amount) {
        acc.setBalance(acc.getBalance() - amount);
        stateCheck();

    }

    @Override
    public void computeInterest() {
        System.out.println("正常状态，无须支付利息");

    }

    //状态转换

    @Override
    public void stateCheck() {
        if (acc.getBalance() > -2000 && acc.getBalance() <= 0) {
            acc.setState(new OverdraftState(this));
        } else if (acc.getBalance() == -2000) {
            acc.setState(new RestrictedState(this));

        } else if (acc.getBalance() < -2000) {
            System.out.println("operation permission denid");
        }
    }
}
