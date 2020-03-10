package com.edison.algorithm.algorithm;

import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2020/3/1下午4:02
 * @Created by edsiongeng
 */
public class InfixToSuffix {
    //定义运算符栈
    private MyCharStack s1;
    //定义存储结果栈
    private MyCharStack s2;
    private String input;

    public InfixToSuffix(String in) {
        input = in;
        s1 = new MyCharStack(input.length());
        s2 = new MyCharStack(input.length());
    }

    public MyCharStack doTrans() {
        for (int j = 0; j < input.length(); j++) {
            System.out.print("s1栈元素为：");
            s1.displayStack();
            System.out.print("s2栈元素为：");
            s2.displayStack();
            char ch = input.charAt(j);
            System.out.println("当前解析字符" + ch);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    s1.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    //如果当前解析的字符是操作数，则直接压入s2;
                    s2.push(ch);
                    break;
            }
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2;
    }

    public void gotOper(char opThis, int perc1) {
        while (!s1.isEmpty()) {
            char opTop = s1.pop();
            if (opTop == '(') {//如果栈顶是（，直接将操作符压入s1
                s1.push(opTop);
                break;
            } else {
                int perc2;
                if (opTop == '+' || opTop == '-') {
                    perc2 = 1;
                } else {
                    perc2 = 2;
                }
                if (perc2 < perc1) {
                    s1.push(opTop);
                    break;
                } else {
                    //如果当前运算符与栈顶运算符相同或者小于优先级别，那么将S1栈顶的运算符弹出并压入S2中
                    //并且要再次转到while　循环与s1中新的栈顶运算符相比较：
                    s2.push(opTop);
                }
            }
        }

        s1.push(opThis);
    }

    // 当前字符是'）'时，如果栈顶是'（'，则将这一对括号丢弃，否则依次弹出s1栈顶顶字符，
    // 压入s2,直到遇到'（'
    public void gotParen(char ch) {
        while (!s1.isEmpty()) {
            char chx = s1.pop();
            if (chx == '(') {
                break;
            } else {
                s2.push(chx);
            }
        }
    }

    public static void main(String[] args) {
        String input;
        System.out.println("Enter infix: ");

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        InfixToSuffix in=new InfixToSuffix(input);

        MyCharStack my=in.doTrans();
        my.displayStack();
    }
}
