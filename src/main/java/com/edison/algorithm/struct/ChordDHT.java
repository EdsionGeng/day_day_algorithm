package com.edison.algorithm.struct;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class ChordDHT {

    private HashMap<Integer, Node> nodeSet;

    public ChordDHT(int m, String srcfile) throws IOException {
//        this.nodeSet = new HashMap<>();
//        Scanner inFile = new Scanner(Path.of(srcfile), StandardCharsets.UTF_8);
//        Node firstNode = null;
//
//        while (inFile.hasNext() == true) { //加入初始节点
//            String ip = inFile.nextLine();
//            Node node = new Node(m, ip);
//            if (firstNode == null) firstNode = node;
//            this.joinToRing(firstNode, node, m);
//        }
//        inFile.close();
    }

    /**
     * 处理新节点的加入
     * 89        * 除了改变前驱后继关系，还可能存在key的迁移，
     * 90        * 因为这可能会改变某个节点负责的标识符范围
     * 91        * @param curNode 当前节点 (受理加入请求的节点)
     * 92        * @param id 请求加入的节点
     * 93        * @param m 标识符空间位数
     * 94        * @return 是否加入成功
     */
    public boolean joinToRing(Node curNode, Node id, int m) {
        if (this.nodeSet.isEmpty() == false) {
            Node successor = this.searchNode(curNode, id, m);


        }
        return false;
    }

    public Node searchNode(Node curNode, Node id, int m) {
        Node result = null;

        if (curNode.inStorageBound(id.identifier, m) == true) {
            result = curNode;
        } else {

        }
        return result;
    }

    public class Node {
        private int identifier;
        private HashMap<Integer, Node> fingerTable;
        private HashMap<Integer, String> keyList;
        private Node predecessor;
        private Node successor;

        public Node(int m, String ip) {

        }

        private int hashFunc(int m, String ip) {
            Random rd = new Random(System.currentTimeMillis());
            int result = 0;
            for (int i = 0; i < ip.length(); i++) {
                if (ip.charAt(i) <= '9' && ip.charAt(i) >= '0') {
                    result = (result + (int) ip.charAt(i)) % (int) Math.pow(2, m);
                }
            }
            return result % (int) Math.pow(2, m);
        }

        public HashMap<Integer, Node> getFingerTable() {
            return this.fingerTable;
        }//负责标识符的范围

        /**
         * 217       * 这里可能有三种可能：
         * 218       * 1. 前驱节点标识符更大（如，23 ---> 1）
         * 219       * 2. 前驱节点标识符更小（如，23 ---> 27）
         * 220       * 3. 前驱节点标识符一样大（环中只有一个节点时）
         * 221
         */

        public boolean inStorageBound(int aIdentifier, int m) {
            int lower = this.predecessor.identifier;
            int upper = this.identifier;

            if (lower > upper) {
                if (aIdentifier > lower && aIdentifier < (int) Math.pow(2, m)) {
                    return true;
                }
                if (aIdentifier < upper) {
                    return true;
                }
            }
            if (aIdentifier > lower && aIdentifier <= upper) {
                return true;
            }
            if (lower == upper) {
                return true;
            }
            return false;

        }

    }
}
