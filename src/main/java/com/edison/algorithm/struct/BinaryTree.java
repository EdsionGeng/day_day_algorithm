package com.edison.algorithm.struct;

/**
 * @Description 二叉树
 * @Date 2020/3/3下午6:52
 * @Created by edsiongeng
 */
public class BinaryTree {
    private Node root;

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.data > key) {
                current = current.leftChild;
            } else if (current.data < key) {
                current = current.rightChild;
            } else {
                return current;
            }
        }

        return null;
    }

    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parentNode = null;
            while (current != null) {
                parentNode = current;
                if (current.data > data) {
                    current = current.leftChild;
                    if (current == null) {
                        parentNode.leftChild = newNode;
                        return true;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parentNode.rightChild = newNode;
                        return true;
                    }
                }

            }
        }
        return false;
    }

    //中序遍历
    public void infixOrder(Node current) {
        if (current != null) {
            infixOrder(current.leftChild);
            System.out.print(current.data + " ");
            infixOrder(current.rightChild);
        }
    }

    //前序遍历
    public void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }

    //后序遍历
    public void postOrder(Node current) {
        if (current != null) {

            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.print(current.data + " ");
        }
    }

    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;

        while (current.data != key) {
            parent = current;
            if (current.data > key) {
                isLeftChild = true;
                current = current.leftChild;
            } else if (current.data < key) {
                current = current.rightChild;

            }
            if (current == null) {
                return false;
            }
        }
        //如果当前节点没有子节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return true;
            //当前节点有一个子节点，右子节点
        } else if (current.leftChild == null && current.rightChild != null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }

            return true;
            //当前节点存在两个子节点
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;
    }

    //得到继任
    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        //后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    private class Node {
        int data;
        Node leftChild;
        Node rightChild;
        boolean isDelete;

        public Node(int data) {
            this.data = data;
        }

        public void display() {
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
//        bt.insert(30);
//        bt.insert(60);
//        bt.insert(90);
//        bt.insert(25);
//        bt.insert(85);
//        bt.insert(100);
        bt.infixOrder(bt.root);
        System.out.println();
        bt.preOrder(bt.root);
        System.out.println();
        bt.postOrder(bt.root);
        System.out.println();

//        bt.delete(10);//删除没有子节点的节点
//        bt.delete(30);//删除有一个子节点的节点
//        bt.delete(80);//删除有两个子节点的节点
//        System.out.println(bt.findMax().data);
//        System.out.println(bt.findMin().data);
//        System.out.println(bt.find(100));
//        System.out.println(bt.find(200));


    }
}
