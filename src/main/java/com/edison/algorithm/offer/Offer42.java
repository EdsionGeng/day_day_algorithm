package com.edison.algorithm.offer;

//连续子数组最大和
public class Offer42 {
    public int maxSubArray(int[] nums) {
        int sum = 0,res=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            }else{
                sum = sum + nums[i];
            }

            res = Math.max(sum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        Offer42 offer = new Offer42();
        System.out.println(offer.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
