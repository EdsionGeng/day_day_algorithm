package com.edison.algorithm.struct;

/**
 * @Description 跳跃表
 * @Date 2020/7/5下午4:32
 * @Created by edsiongeng
 */
public class SkipList {
    int maxLevel = 16;
    Node head = new Node(-1, 16);
    //当前跳跃表节点的个数
    int size = 0;
    //当前跳跃表的层数，初始化为1层
    int levelCount = 1;


    public Node find(int value) {
        Node temp = head;
        for (int i = levelCount - 1; i >= 0; i--) {

            while (temp.next[i] != null && temp.next[i].value < value) {
                temp = temp.next[i];
            }
        }
        //判断该元素是否存在
        if (temp.next[0] != null && temp.next[0].value == value) {
            System.out.println(value + " find success");
            return temp.next[0];
        } else {
            return null;
        }
    }
    //为了方便，跳跃表在插入时候，插入节点在当前跳跃表是不存在的，不允许插入重复数值节点

    public void insert(int value) {
        int level = getLevel();

        Node newNode = new Node(value, level);
        //update记录插入节点的前驱
        Node[] update = new Node[level];

        Node temp = head;
        for (int i = level - 1; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].value < value) {
                temp = temp.next[i];
            }
            update[i] = temp;
        }
        //把插入节点的每一层连接起来
        for (int i = 0; i < level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
        //判断是否需要更新跳跃表的层数
        if (level > levelCount) {
            levelCount = level;
        }
        size++;
        System.out.println(value + " insert success");

    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node temp = head;

        for (int i = levelCount - 1; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].value < value) {
                temp = temp.next[i];
            }
            update[i] = temp;
        }
        if (temp.next[0] != null && temp.next[0].value == value) {
            size--;
            System.out.println(value + " delete success");
            for (int i = levelCount - 1; i >= 0; i--) {
                if (update[i].next[i] != null && update[i].next[i].value == value) {
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
        }
    }

    //模拟抛硬币
    private int getLevel() {
        int level = 1;
        while (true) {
            int t = (int) (Math.random() * 100);
            if (t % 2 == 0) {
                level++;
            } else {
                break;
            }
        }
        System.out.println("当前的level=" + level);
        return level;
    }

    public void printAllNode() {
        Node temp = head;
        while (temp.next[0] != null) {
            System.out.println(temp.next[0].value + " ");
            temp = temp.next[0];
        }
    }

    class Node {
        int value = -1;
        int level;//跨越几层
        Node[] next;//指向下一个节点

        public Node(int value, int level) {
            this.value = value;
            this.level = level;
            this.next = new Node[level];
        }
    }
}
