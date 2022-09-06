package com.edison.algorithm.algorithm;

import java.util.*;

/**
 * 描述:
 * 最佳调度问题
 *
 * @author gengyc
 * @create 2021-12-22 9:50
 */
public class BestSchedule {

    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        //   int machine = 4;
        int[] time = {3, 4, 1, 2, 5, 3, 7, 6, 9, 10};
        Arrays.sort(time);
        int[] reverse = new int[10];
        for (int i = time.length - 1, j = 0; i >= 0; i--, j++) {
            reverse[j] = time[i];
        }
        int[] total = {0, 0, 0};
        for (int i = 0; i < reverse.length; i++) {
            int minValue = total[0];
            int k = 0;
            for (int j = 0; j < total.length; j++) {
                if (minValue > total[j]) {
                    k = j;
                    minValue = total[j];
                }
            }
            total[k] += reverse[i];
            if (!map.containsKey(k)) {
                List<Integer> list = new ArrayList<>();
                list.add(reverse[i]);
                map.put(k, list);
            } else {
                List<Integer> list = map.get(k);
                list.add(reverse[i]);
                map.put(k, list);
            }
        }
        for (int i = 0; i < total.length; i++) {
            System.out.println(total[i]);
        }
        for (Map.Entry<Integer, List<Integer>> map : map.entrySet()) {
            System.out.print(map.getKey() + "->");
            for (Integer i : map.getValue()) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


}