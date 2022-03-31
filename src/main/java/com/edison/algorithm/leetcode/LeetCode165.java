package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 比较版本号
 *
 * @author gengyc
 * @create 2022-02-25 17:04
 */
public class LeetCode165 {
    //输入: version1 = “0.1”, version2 = “1.1”
    //输出: -1
    //示例 2:
    //
    //输入: version1 = “1.0.1”, version2 = “1”
    //输出: 1
    //示例 3:
    //
    //输入: version1 = “7.5.2.4”, version2 = “7.5.3”
    //输出: -1
    //示例 4：
    //
    //输入：version1 = “1.01”, version2 = “1.001”
    //输出：0
    //解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
    //示例 5：
    //
    //输入：version1 = “1.0”, version2 = “1.0.0”
    //输出：0
    //解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
    //————————————————
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split(".");
        String[] a2 = version2.split(".");
        for (int i = 0; i < Math.max(a1.length, a2.length); i++) {
            int a = i < a1.length ? Integer.valueOf(a1[i]) : 0;
            int b = i < a2.length ? Integer.valueOf(a2[i]) : 0;
            if (a < b) return -1;
            else if (a > b) return 1;
        }
        return 0;
    }

}