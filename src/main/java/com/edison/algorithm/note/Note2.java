//package com.edison.algorithm.note;
//
///**
// * @Description 树状数组BIT
// * @Date 2021/3/3下午11:27
// * @Created by edsiongeng
// */
//public class Note2 {
//    static int N = 10;
//
//    private int tree[] = new int[N];
//
//    public Note2() {
//        for (int i = 0; i < N; i++) {
//            tree[i] = i;
//        }
//    }
//
//    public void update(int i, int x) {
//        for (int pos = i; pos < N; pos += lowbit(pos)) {
//            tree[pos] += x;
//        }
//    }
//
//    /**
//     * 求前N项和
//     *
//     * @param n
//     * @return
//     */
//
//    public int query(int n) {
//        int answer = 0;
//        for (int pos = n; pos; pos -= lowbit(pos)) {
//            answer += tree[pos];
//        }
//        return answer;
//    }
//
//    public int query(int a, int b) {
//        return query(b) - query(a - 1);
//    }
//
//
//    int lowbit(int x) {
//        return x & (-x);
//
//    }
//
//
//    public static void main(String[] args) {
//        Note2 note2 = new Note2();
//        System.out.println(note2.query(3));
//    }
//}