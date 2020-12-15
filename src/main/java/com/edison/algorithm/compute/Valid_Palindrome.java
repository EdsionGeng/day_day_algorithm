package com.edison.algorithm.compute;

/**
 * @Description 验证是否是回文字符串
 * @Date 2019/12/5上午12:12
 * @Created by edsiongeng
 */
public class Valid_Palindrome {
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        char ch_1, ch_2;
        while (i <= j) {
            ch_1 = s.charAt(i);
            ch_2 = s.charAt(j);
            if (Character.isLetterOrDigit(ch_1) && Character.isLetterOrDigit(ch_2)) {
                if (Character.toLowerCase(ch_1) == Character.toLowerCase(ch_2)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else if (Character.isLetterOrDigit(ch_1)) {
                j--;
            } else {
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man,a plan,a cnaalPanma";
        System.out.println(Valid_Palindrome.isPalindrome(s));
        String str="abcdcba";
        System.out.println(Valid_Palindrome.isPalindrome(str));
    }

}
