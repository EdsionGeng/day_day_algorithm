package com.edison.algorithm.algorithm;

import java.util.Scanner;

/**
 * 描述:
 *
 * @author gengyongchang
 * @create 2020-05-21 16:12
 */
public class YuesefuCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int interval = scanner.nextInt();
        int p = 0;
        for (int i = 2; i <= total; i++) {
            p = (p + interval) % i;
        }
        System.out.println(p+1);
    }
}