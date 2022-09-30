package com.edison.algorithm.offer;

//数组中出现的次数
public class Offer56 {

    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        int div = ret & -ret;

        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & -twos;
            twos = twos ^ num & -ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        Offer56 offer56 = new Offer56();
        System.out.println(offer56.singleNumbers(new int[]{2, 2, 4, 4, 3, 6}));
    }

}
