package com.edison.algorithm.struct;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * B+Tree
 */
public class BPlusTree<T, V extends Comparable<V>> {
    //B+树的阶
    private Integer bTreeOrder;
    //B+树的非叶子节点最小拥有的子节点数量（同时也是键的最小数量）
    //private Integer minNUmber;
    //B+树的非叶子节点最大拥有的节点数量（同时也是键的最大数量）
    private Integer maxNumber;

    private Node<T, V> root;

    private LeafNode<T, V> left;

    abstract class Node<T, V extends Comparable<V>> {
        protected Node<T, V> parent;
        protected Node<T, V>[] childs;
        protected Integer number;
        protected Object keys[];

        public Node() {
            this.keys = new Object[maxNumber];
            this.childs = new Node[maxNumber];
            this.number = 0;
            this.parent = null;
        }

        abstract T find(V key);

        abstract Node<T, V> insert(T value, V key);

        abstract LeafNode<T, V> refreshLeft();
    }

    class LeafNode<T, V extends Comparable<V>> extends Node<T, V> {
        protected Object values[];
        protected LeafNode left;
        protected LeafNode right;

        public LeafNode() {
            super();
            this.values = new Object[maxNumber];
            this.left = null;
            this.right = null;
        }

        @Override
        T find(V key) {
            if (this.number <= 0) {
                return null;
            }
            Integer left = 0;
            Integer right = this.number;
            Integer middle = (left + right) / 2;
            while (left < right) {
                V middleKey = (V) this.keys[middle];
                if (key.compareTo(middleKey) == 0) {
                    return (T) this.values[middle];
                } else if (key.compareTo(middleKey) < 0) {
                    right = middle;
                } else {
                    left = middle;
                }
                middle = (left + right) / 2;
            }
            return null;
        }

        @Override
        Node<T, V> insert(T value, V key) {
            V oldKey = null;
            if (this.number > 0) {
                oldKey = (V) this.keys[this.number - 1];
            }
            int i = 0;
            while (i < this.number) {
                if (key.compareTo((V) this.keys[i]) < 0) {
                    break;
                }
                i++;
            }
            Object tempKeys[] = new Object[maxNumber];
            Object tempValues[] = new Object[maxNumber];
            System.arraycopy(this.keys, 0, tempKeys, 0, i);
            System.arraycopy(this.values, 0, tempValues, 0, i);
            System.arraycopy(this.keys, i, tempKeys, i + 1, this.number - i);
            System.arraycopy(this.values, i, tempValues, i + 1, this.number - i);
            tempKeys[i] = key;
            tempValues[i] = value;

            this.number++;

            if (this.number <= bTreeOrder) {
                System.arraycopy(tempKeys, 0, this.keys, 0, this.number);
                System.arraycopy(tempValues, 0, this.values, 0, this.number);
                Node node = this;
                while (node.parent != null) {
                    V tempKey = (V) node.keys[node.number - 1];
                    if (tempKey.compareTo((V) node.parent.keys[node.parent.number - 1]) > 0) {
                        node.parent.keys[node.parent.number - 1] = tempKey;
                        node = node.parent;
                    } else {
                        break;
                    }
                }
            }
            return null;
        }

        @Override
        LeafNode<T, V> refreshLeft() {
            if (this.number <= 0) {
                return null;
            }
            return this;
        }
    }

    class BPlusNode<T, V extends Comparable<V>> extends Node<T, V> {
        public BPlusNode() {
            super();
        }

        @Override
        T find(V key) {
            int i = 0;
            while (i < this.number) {
                if (key.compareTo((V) this.keys[i]) <= 0) {
                    break;
                }
                i++;
            }
            if (this.number == i) return null;
            return this.childs[i].find(key);
        }

        @Override
        Node<T, V> insert(T value, V key) {
            int i = 0;
            while (i < this.number) {
                if (key.compareTo((V) this.keys[i]) < 0) {
                    break;
                }
                i++;
            }
            if (key.compareTo((V) this.keys[this.number - 1]) >= 0) {
                i--;
            }
            return this.childs[i].insert(value, key);
        }

        @Override
        LeafNode<T, V> refreshLeft() {
            return this.childs[0].refreshLeft();
        }
    }
}
