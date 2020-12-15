package com.edison.algorithm.compute;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 验证字符串是不是和正则规律一致
 *
 * @author gengyongchang
 * @create 2019-12-14 16:28
 */
public class Word_Pattern {
    public static boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(arr[i])) {
                    return false;
                }
            }
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(arr[i])) {
                    return false;
                }
            }
            map.put(pattern.charAt(i), arr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "dog do dog";
        String pattern = "aaa";
        System.out.println(wordPattern(pattern, str));
    }


}