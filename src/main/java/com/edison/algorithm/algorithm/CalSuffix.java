package com.edison.algorithm.algorithm;

import com.edison.algorithm.struct.MyStack;

/**
 * @Description 后缀表达式计算机求值
 * @Date 2020/3/1下午4:38
 * @Created by edsiongeng
 */
public class CalSuffix {

    private MyStack myStack;
    private String input;

    public CalSuffix(String input) {
        this.input = input;
        myStack = new MyStack(input.length());
    }

    public int doCalc() {
        int num1, num2, result = 0;
        for (int i = 0; i < input.length(); i++) {
            char s = input.charAt(i);
            if (s >= '0' && s <= '9') {
                myStack.push((s - '0'));
            } else {
                num2 = myStack.pop();
                num1 = myStack.pop();
                switch (s) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
                myStack.push(result);
            }
        }
        result = myStack.pop();
        return result;
    }

    public static void main(String[] args) {
        //中缀表达式：1*(2+3)-5/(2+3) = 4
        //后缀表达式：123+*123+/-
        CalSuffix cs = new CalSuffix("123+*523+/-");
        System.out.println(cs.doCalc()); //4
    }
}
