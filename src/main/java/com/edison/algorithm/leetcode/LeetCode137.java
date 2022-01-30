package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 只出现一次数字2
 *
 * @author gengyc
 * @create 2022-01-30 9:28
 */
public class LeetCode137 {
    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
    //
    //说明：
    //
    //你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    //
    //示例 1:
    //
    //输入: [2,2,3,2]
    //输出: 3
    //示例 2:
    //
    //输入: [0,1,0,1,0,1,99]
    //输出: 99
    //
    //PS：
    //对每一位单独统计出现1的次数, 如果出现的次数不能整除3说明唯一存在的数在这一位上为1, 时间复杂度O(32N)

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; ++i) {
            int bitnums = 0;
            int bit = 1 << i;
            for (int num : nums) {
                if ((num & bit) != 0) {
                    bitnums++;
                }
            }
            if (bitnums % 3 != 0) {
                ret |= bit;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode137 le = new LeetCode137();
        System.out.println(le.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }

}