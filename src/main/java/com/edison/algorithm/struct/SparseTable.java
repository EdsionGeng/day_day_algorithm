package com.edison.algorithm.struct;

/**
 * 描述:
 * 稀疏表
 *
 * @author gengyc
 * @create 2021-12-08 9:30
 */
public class SparseTable {
    int rowTotalNum;
    int colTotalNum;
    LinkedList2[] row;
    LinkedList2[] col;

    public SparseTable() {
        rowTotalNum = 500;
        colTotalNum = 500;
        row = new LinkedList2[rowTotalNum];
        col = new LinkedList2[colTotalNum];
        for (int i = 0; i < rowTotalNum; i++) {
            row[i] = new LinkedList2();
        }
        for (int i = 0; i < colTotalNum; i++) {
            col[i] = new LinkedList2();
        }
    }

    void insert(int value, int rowIndex, int colIndex) {
        if (rowIndex >= rowTotalNum || colIndex >= colTotalNum) {
            return;
        }

    }

    void remove(int rowIndex, int colIndex) {

    }

    class Node {
        int row;
        int col;
        int value;    //存储节点的值
        Node next;    //存储下一个节点的指针

        Node(int aValue, int aRow, int aCol) {    //构造函数，必须传入结点的值，下一个节点默认为null
            this.value = aValue;
            this.next = null;
            this.row = aRow;
            this.col = aCol;
        }

        Node(int aValue, int aRow, int aCol, Node aNext) {    //构造函数，必须传入结点的值，下一个节点默认为null
            this.value = aValue;
            this.next = aNext;
            this.row = aRow;
            this.col = aCol;
        }
    }

    class LinkedList2 {
        int length;
        Node head;
        Node tail;

        LinkedList2() {
            length = 0;
            head = tail = null;
        }

        void insertToCol(int value, int row, int col) {
        }



        int isEmpty() {
            return head == null ? 1 : 0;
        }
    }
}