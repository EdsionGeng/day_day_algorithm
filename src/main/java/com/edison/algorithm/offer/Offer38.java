package com.edison.algorithm.offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//字符串排列组合
public class Offer38 {
    List<String> result = new ArrayList<>();
    boolean[] vis;

    public String[] permutation(String s) {
        vis = new boolean[s.length()];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        dfs(arr, new StringBuilder(), 0, s.length());
        String[] recArr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            recArr[i] = result.get(i);
        }
        return recArr;
    }

    public void dfs(char[] arr, StringBuilder str, int index, int length) {

        if (index == length) {
            result.add(str.toString());
            return;
        }
        for (int i = 0; i < length; i++) {
            if (vis[i] || (i > 0 && !vis[i - 1] && arr[i - 1] == arr[i])) {
                continue;
            }
            vis[i] = true;
            str.append(arr[i]);
            dfs(arr, str, index + 1, length);
            str.deleteCharAt(str.length() - 1);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {
        Offer38 offer = new Offer38();
        System.out.println(offer.permutation("abc"));
    }
}
