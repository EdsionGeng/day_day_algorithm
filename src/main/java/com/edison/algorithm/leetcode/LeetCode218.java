package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 天际线问题
 *
 * @author gengyc
 * @create 2022-03-11 17:19
 */
public class LeetCode218 {
    public List<List<Integer>> getSkyLine(int[][] buildings) {
        return segment(buildings, 0, buildings.length - 1);
    }

    private List<List<Integer>> segment(int[][] buildings, int l, int r) {
        List<List<Integer>> res = new ArrayList<>();
        if (l == r) {
            res.add(Arrays.asList(buildings[l][0], buildings[l][2]));
            res.add(Arrays.asList(buildings[l][1], 0));
            return res;
        }
        int mid = l + (r - l) / 2;
        //左边递归
        List<List<Integer>> left = segment(buildings, l, mid);
        //右边递归
        List<List<Integer>> right = segment(buildings, mid + 1, r);
        int m = 0, n = 0;
        // 创建left 和 right 目前的高度
        int lpreH = 0, rpreH = 0;
        // 两个坐标
        int leftX, leftY, rightX, rightY;
        while (m < left.size() || n < right.size()) {

            // 当有一边完全加入到res时，则加入剩余的那部分
            if (m >= left.size()) res.add(right.get(n++));
            else if (n >= right.size()) res.add(left.get(m++));

            else { // 开始判断left 和 right
                leftX = left.get(m).get(0); // 不会出现null，可以直接用int类型
                leftY = left.get(m).get(1);
                rightX = right.get(n).get(0);
                rightY = right.get(n).get(1);
                //看我这两个矩形谁靠左
                if (leftX < rightX) {
                    //左面还比以前高，就加左面
                    if (leftY > rpreH) res.add(left.get(m));
                        //左面比右面高，我要加入左面点的以及以前右面的的高度，因为我马上就有新高度了2，10
                    else if (lpreH > rpreH) res.add(Arrays.asList(leftX, rpreH));
                    //  用我左面的高替换我以前右面的高
                    lpreH = leftY;
                    m++;
                } else if (leftX > rightX) {
                    if (rightY > lpreH) res.add(right.get(n));
                    else if (rpreH > lpreH) res.add(Arrays.asList(rightX, lpreH));
                    rpreH = rightY;
                    n++;
                } else { // left 和 right 的横坐标相等
                    if (leftY >= rightY && leftY != (lpreH > rpreH ? lpreH : rpreH)) res.add(left.get(m));
                    else if (leftY <= rightY && rightY != (lpreH > rpreH ? lpreH : rpreH)) res.add(right.get(n));
                    lpreH = leftY;
                    rpreH = rightY;
                    m++;
                    n++;
                }
            }
        }
        return res;
    }
}