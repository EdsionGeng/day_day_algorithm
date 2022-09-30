package com.edison.algorithm.offer;

//调整数组顺序使奇数位于偶数前面
public class Offer21 {

    public int[] exchange(int[] nums) {
        int[] odd = new int[nums.length];
        int j = 0, r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                odd[j++] = nums[i];

            } else {
                odd[r--] = nums[i];
            }
        }
        return odd;
    }

    public static void main(String[] args) {
        Offer21 o = new Offer21();
        System.out.println(o.exchange(new int[]{1, 2, 3, 4,8,9,7}));
    }
}
