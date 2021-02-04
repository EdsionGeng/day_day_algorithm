package com.edison.algorithm.struct;

/**
 * @Description 二叉搜索🌲
 * @Date 2020/8/27下午10:55
 * @Created by edsiongeng
 */
public class BST {

    private Node root;


    public boolean isExist(Node root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.val < target) {
            return isExist(root.left, target);
        }
        if (root.val > target) {
            return isExist(root.right, target);
        }
        return false;
    }

    Node insertBST(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.val > val) {
            root.left = insertBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertBST(root.right, val);
        }
        return root;
    }

    Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                root = null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node minNode = getMinNode(root.right);
            root.val = minNode.val;
            deleteNode(root.right, minNode.val);

        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    Node getMinNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public boolean isSameTree(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }


    private class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

    }

}

