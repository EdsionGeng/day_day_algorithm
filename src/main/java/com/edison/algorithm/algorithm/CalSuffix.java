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
        int num1, num2, result;
        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);
            if (c >= '0' && c <= '9') {
                myStack.push((int) (c - '0'));//如果是数字，直接压入栈中
            } else {
                num2 = myStack.pop();//注意先出来的为第二个操作数
                num1 = myStack.pop();
                switch (c) {
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
                    default:
                        result = 0;
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
