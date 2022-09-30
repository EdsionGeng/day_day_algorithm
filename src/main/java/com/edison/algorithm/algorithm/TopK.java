package com.edison.algorithm.algorithm;

import java.util.*;

/**
 * 描述:
 * TopK算法
 *
 * @author gengyc
 * @create 2021-12-09 16:39
 */
public class TopK {

    class MinHeap {
        private int[] data;

        public MinHeap(int[] data) {
            this.data = data;
            buildHeap();
        }

        private void buildHeap() {
            for (int i = (data.length - 2) / 2; i >= 0; i--) {
                heapify(i);
            }
        }

        private void heapify(int len) {
            int parent = len;
            int child = parent * 2 + 1;
            while (child < data.length) {
                if (child + 1 < data.length && data[child] > data[child + 1]) {
                    child++;
                }
                if (data[parent] > data[child]) {
                    swap(data, parent, child);
                    parent = child;
                    child = parent * 2 + 1;
                } else {
                    break;
                }
            }
        }

        private int getHeapTop() {
            if (data.length == 0) {
                throw new UnsupportedOperationException("Heap is empty,cant get value!");
            }
            return this.data[0];
        }

        private void addHeap(int num) {
            this.data[0] = num;
            heapify(0);
        }


        private void swap(int[] data, int a, int b) {
            int temp = data[a];
            data[a] = data[b];
            data[b] = temp;
        }
    }

    public int[] topK(int[] data, int k) {
        int[] topK = new int[k];
        System.arraycopy(data, 0, topK, 0, k);
        MinHeap minHeap = new MinHeap(topK);
        for (int i = k; i < data.length; i++) {
            int root = minHeap.getHeapTop();
            if (data[i] > root) {
                minHeap.addHeap(data[i]);
            }
        }
        return topK;


    }

    public static void main(String[] args) {
        TopK top = new TopK();
        int[] data = {12, 10, 4, 7, 30, 9, 6, 20};
        //提取data中的三个最大元素
        int[] topK = top.topK(data, 3);
        //12 30 20
        //输出topK数组中的元素
        for (int i = 0; i < topK.length; i++) {
            System.out.print(topK[i] + " ");
        }
        System.out.println();

    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int[] counter = new int[10001];
        for (int num : arr) {
            counter[num]++;
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]-- > 0 && idx < k) {
                res[idx++] = i;
            }
            if (idx == k) break;
        }
        return res;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num : arr) {
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }

    public int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (Integer num : queue
        ) {
            res[idx++] = num;
        }
        return res;
    }

    public int[] getLeastNumbers4(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        return quickSearch(arr, 0, arr.length - 1, k - 1);

    }

    private int[] quickSearch(int[] nums, int low, int high, int k) {
        int j = partition(nums, low, high);
        if (j == k) return Arrays.copyOf(nums, j + 1);
        return j > k ? quickSearch(nums, low, j - 1, k) : quickSearch(nums, j + 1, high, k);
    }

    private int partition(int[] nums, int low, int high) {
        int v = nums[low];
        int i = low, j = high + 1;
        while (true) {
            while (++i <= high && nums[i] < v) ;
            while (--j >= low && nums[j] > v) ;
            if (i >= j) break;
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[low] = nums[j];
        nums[j] = v;
        return j;
    }

}