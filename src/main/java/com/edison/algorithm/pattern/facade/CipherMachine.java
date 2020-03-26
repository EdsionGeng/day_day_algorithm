package com.edison.algorithm.pattern.facade;

/**
 * @Description TODO
 * @Date 2020/3/21上午8:50
 * @Created by edsiongeng
 */
public class CipherMachine {
    public String encrypt(String plainText) {
        System.out.println("start cipher ->");
        String es = "";
        char[] chars = plainText.toCharArray();
        for (char ch : chars) {
            String c = String.valueOf(ch % 7);
            es += c;
        }
        System.out.println(es);
        return es;
    }
}
