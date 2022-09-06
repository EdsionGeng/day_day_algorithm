package com.edison.algorithm.compress;

import java.util.ArrayList;
import java.util.Scanner;

public class EliasCode {

    public String eliasGammaEncode(int n) {
        String s = intToBinaryString(n);
        s = addHeadZeros(s);
        return s;
    }

    public ArrayList<Integer> eliasGammaDecodeToArray(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        while (s.length() > 0) {
            int n = eliasGammaDecode(s);
            list.add(n);
            s = s.substring(eliasGammaEncode(n).length());
        }
        return list;
    }

    public int eliasGammaDecode(String s) {
        int len = getHeadZerosCount(s);
        if (len <= 0) {
            throw new IllegalArgumentException("illegal length");
        }
        s = s.substring(len);
        String binary = s.substring(0, len + 1);
        int n = binaryStringToInt(binary);
        return n;
    }

    public int getHeadZerosCount(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0'){
                n++;
            }
        }
        return n;
    }

    public int binaryStringToInt(String binary) {
        int n = 0;
        return n;
    }

    public String intToBinaryString(int n) {
        String s = "";
        while (n > 0) {
            if ((n & 1) == 0) {
                s = "0" + s;
            } else {
                s = "1" + s;
            }
            n = n >> 1;
        }
        return s;
    }

    public String addHeadZeros(String s) {
        int n = s.length();
        String s1 = s;
        for (int i = 0; i < n - 1; i++) {
            s1 = "0" + s1;
        }
        return s1;
    }

    public static void main(String[] args) {
        EliasCode e = new EliasCode();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //编码
        System.out.println(e.eliasGammaEncode(n));
        //解码
        System.out.println(e.eliasGammaDecode(e.eliasGammaEncode(n)));

    }
}
