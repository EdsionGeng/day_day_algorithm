package com.edison.algorithm.offer;

//替换空格
public class Offer05 {
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Offer05 o = new Offer05();
        System.out.println(o.replaceSpace("We are happy"));
    }
}
