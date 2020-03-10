package com.edison.algorithm.compute;

/**
 * @Description 字符串反转
 * @Date 2019/12/5上午12:23
 * @Created by edsiongeng
 */
public class ReverseString {
    public static String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            stringBuilder.setCharAt(i, s.charAt(j));
            stringBuilder.setCharAt(j, s.charAt(i));
            i++;
            j--;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "hello world";
        System.out.println(reverseString(str));
    }

}
