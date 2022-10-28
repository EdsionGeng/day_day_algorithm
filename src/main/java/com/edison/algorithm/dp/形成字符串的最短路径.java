package com.edison.algorithm.dp;

public class 形成字符串的最短路径 {

    public int shortestWay(String source, String target) {
        int target_index = 0;
        int source_index = 0;
        int count = 0;
        while (target_index < target.length()) {
            if (!source.contains(target.charAt(target_index) + "")) return -1;
            if (target.charAt(target_index) == source.charAt(source_index)) {
                source_index++;
                target_index++;
            } else {
                source_index++;
            }
            if (source_index == source.length()) {
                count++;
                source_index = 0;
            }
        }
        if (source_index != 0) {
            count++;
        }
        return count;
    }
}
