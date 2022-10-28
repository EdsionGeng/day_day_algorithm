package com.edison.algorithm.offer;

//实现除法
public class Offer001 {

    public int divide(int a, int b) {
        int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE,MIN_LIMIT=MIN>>1;
        if (a == MIN && b == -1) return MAX;
        boolean isPos = (a < 0 && b > 0) || (a > 0 && b < 0) ? false : true;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int ans = 0;
        while (a <= b) {
            int d = b, c = 1;
            while (d >=MIN_LIMIT && d + d >=a) {
                d += d;
                c += c;
            }
            a -= d;
            ans += c;
        }
        return isPos ? ans : -ans;

    }

    public static void main(String[] args) {
        Offer001 o = new Offer001();
        System.out.println(o.divide(-15,2));
    }
}
