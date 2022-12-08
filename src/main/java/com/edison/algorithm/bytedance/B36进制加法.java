package com.edison.algorithm.bytedance;

public class B36进制加法 {


    char getChar(int n) {
        if (n <= 9) {
            return (char) (n + '0');
        }
        return (char) (n - 10 + 'a');
    }

    int getInt(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        }
        return ch - 'a' + 10;
    }


    public String add36(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuffer res = new StringBuffer();

        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? getInt(num1.charAt(i)) : 0;
            int y = j >= 0 ? getInt(num2.charAt(j)) : 0;
            int temp = x + y + carry;
            res.append(getChar(temp % 36));
            carry = temp / 36;
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        B36进制加法 b = new B36进制加法();
        System.out.println(b.add36("1b", "2x"));
    }
}
