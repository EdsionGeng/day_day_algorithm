package com.edison.algorithm.offer;

//旋转数组的最小数字
public class Offer11 {

    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = (high + low) / 2;
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else if (numbers[mid] < numbers[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        Offer11 offer11 = new Offer11();
        System.out.println(offer11.minArray(new int[]{1, 3, 3}));
    }
}
