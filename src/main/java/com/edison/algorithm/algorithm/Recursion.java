package com.edison.algorithm.algorithm;



/**
 * @Description 递归
 * @Date 2020/3/2下午2:43
 * @Created by edsiongeng
 */
public class Recursion {

    //阶乘
    public static int getFactorial(int n) {
        if (n >= 0) {
            if (n == 0) {
                System.out.println(n + "!=1");
                return 1;
            } else {
                System.out.println(n);
                int temp = n * getFactorial(n - 1);
                System.out.println(n + "!=" + temp);
                return temp;
            }
        }
        return -1;
    }

    public static int search(int[] array, int key, int high, int low) {
        int mid = (high - low) / 2 + low;
        if (key == array[mid]) {
            return mid;
        } else if (low > high) {
            return -1;
        } else {
            if (key < array[mid]) {
                search(array, key, low, mid - 1);
            }
            if (key > array[mid]) {
                search(array, key, mid + 1, high);
            }
        }
        return -1;
    }

    /**
     * 汉诺塔问题
     *
     * @param dish 盘子个数
     * @param from 初始塔座
     * @param temp 中介塔座
     * @param to   目标塔座
     */
    public static void move(int dish, String from, String temp, String to) {
        if (dish == 1) {
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标塔座" + to);
        } else {
            move(dish - 1, from, to, temp);
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标塔座" + to);

            move(dish - 1, temp, from, to);
        }
    }


    public static void main(String[] args) {

        move(2, "A", "B", "C");
    }
}
