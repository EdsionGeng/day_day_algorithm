package com.edison.algorithm.offer;

//翻转单词顺序
public class Offer58 {

    public String reverseWords(String s) {

        String[] array = s.trim().split(" ");
        StringBuffer str = new StringBuffer();
        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("")) {
                str.append(array[i]);
                if (i != 0) {
                    str.append(" ");
                }
            }
        }
        return str.toString();
    }

    public String reverseLeftWords(String s, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s.substring(n)).append(s.substring(0, n));
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Offer58 offer58 = new Offer58();
        System.out.println(offer58.reverseWords(" hello world! "));
        System.out.println(offer58.reverseLeftWords("abcdefg", 2));

    }
}
