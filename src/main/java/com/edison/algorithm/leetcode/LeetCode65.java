package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 有效数字
 *
 * @author gengyc
 * @create 2022-01-15 13:13
 */
public class LeetCode65 {
    //“0” => true
//" 0.1 " => true
//“abc” => false
//“1 a” => false
//“2e10” => true
//" -90e3 " => true
//" 1e" => false
//“e3” => false
//" 6e-1" => true
//" 99e2.5 " => false
//“53.5e93” => true
//" --6 " => false
//“-+3” => false
//“95a54e53” => false
//
//说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
//
//数字 0-9
//指数 - “e”
//正/负号 - “+”/"-"
//小数点 - “.”
//当然，在输入中，这些字符的上下文也很重要。
    char[] chars;
    boolean point = false;
    boolean exponent = false;

    public boolean isNumer(String s) {
        s = s.trim();
        int length = s.length();
        if (length == 0) {
            return false;
        }
        chars = s.toCharArray();
        String[] ss = s.split("e");
        if (ss.length == 0) {
            return false;
        }
        //只有e 是错误
        if (ss[0].length() == 0) {
            return false;
        }
        if (ss[0].length() < length) {
            exponent = true;
        }
        if (ss[0].length() == length - 1) {
            return false;
        }
        String[] pre = ss[0].split("\\.");
        if (pre.length == 0) {
            return false;
        }
        if (pre[0].length() < ss[0].length()) {
            point = true;
        }
        boolean result = pre(0, pre[0].length());
        result = result && middle(pre[0].length() + 1, ss[0].length());
        if (exponent) {
            result = result && is(ss[0].length() + 1, length);
        }
        return result;
    }

    //判断整数部分是否正确
    public boolean pre(int i, int length) {
        if (i >= length) {
            return true;
        }
        if (chars[i] == '+' || chars[i] == '-') {
            i++;
        }
        if (i == length && !point) {
            return false;
        }
        for (; i < length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;

    }

    //小数部分
    public boolean middle(int i, int length) {
        if (i >= length && point) {
            if (chars[i - 2] >= '0' && chars[i - 2] <= '9') {
                return true;
            }
            return false;
        }
        for (; i < length; i++) {

            if (chars[i] > '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }

    //指数部分
    public boolean is(int i, int length) {
        if (i == 1) {
            return false;
        }
        if (chars[i] == '+' || chars[i] == '-') {
            i++;
        }
        if (i == length) {
            return false;
        }
        for (; i < length; i++) {

            if (chars[i] > '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}