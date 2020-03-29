package com.edison.algorithm.pattern.command.undo;

/**
 * @Description TODO
 * @Date 2020/3/28上午10:39
 * @Created by edsiongeng
 */
public class Adder {
    private int num = 0;

    public int add(int value) {
        num += value;
        return num;
    }
}
