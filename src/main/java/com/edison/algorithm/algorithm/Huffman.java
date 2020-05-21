package com.edison.algorithm.algorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 描述:
 * 哈夫曼编码
 *
 * @author gengyongchang
 * @create 2020-04-23 14:19
 */
public class Huffman {
    private static LinkedList<HufNode> hufNodeLinkedList = new LinkedList<>();

    class HufNode implements Comparable<HufNode> {
        int value;
        String name;
        HufNode Lchild = null;
        HufNode Rchild = null;

        public HufNode() {

        }

        public HufNode(int v, String s) {
            value = v;
            name = s;
        }

        public HufNode(HufNode l, HufNode r) {
            Lchild = l;
            Rchild = r;
            value = Lchild.value + Rchild.value;
        }

        @Override
        public int compareTo(HufNode node) {
            if (value < node.value) {
                return -1;
            } else if (value == node.value) {
                return 0;
            }
            return 1;
        }
    }

    public static void HufmanCode() {
        if (hufNodeLinkedList.size() == 1) {
            return;
        }
        while (hufNodeLinkedList.size() > 1) {
            Collections.sort(hufNodeLinkedList);
            HufNode node = new Huffman().new HufNode(hufNodeLinkedList.get(0), hufNodeLinkedList.get(1));
            hufNodeLinkedList.remove();
            hufNodeLinkedList.remove();
            hufNodeLinkedList.add(node);
        }
    }

    public static void decode(HufNode n, String code) {
        if (n.Lchild == null && n.Rchild == null) {
            System.out.println("元素值为：" + n.name + " 编码为：" + code);
            System.out.println();
            return;
        }
        decode(n.Lchild, code + "0");
        decode(n.Rchild, code + "1");
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i=0;i<N;i++){
            hufNodeLinkedList.add(new Huffman().new HufNode(scanner.nextInt(),scanner.next()));
        }
        HufmanCode();
        decode(hufNodeLinkedList.get(0), "");
    }
}