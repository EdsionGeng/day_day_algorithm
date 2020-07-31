package com.edison.algorithm.struct;


import java.util.Optional;

/**
 * @Description 红黑树
 * @Date 2020/3/4下午4:58
 * @Created by edsiongeng
 */
public class RDBTree<T extends Comparable<T>> {
    private Boolean RED = Boolean.FALSE;
    private Boolean BLACK = Boolean.TRUE;

    private RBNode<T> root;


    private class RBNode<T extends Comparable<T>> {
        Boolean color;
        T key;
        RBNode<T> left;
        RBNode<T> right;
        RBNode<T> parent;

        public RBNode(boolean color, T key, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        //获得节点的关键值
        public T getKey() {
            return key;
        }


        //打印节点的关键值和颜色信息
        @Override
        public String toString() {
            return "" + key + (this.color.equals(RED) ? "R" : "B");
        }

    }

    public RBNode<T> parentOf(RBNode<T> node) {
        if (node != null) {
            return node.parent;
        }
        return null;
    }

    public void setRed(RBNode<T> node) {
        Optional<RBNode<T>> nodel = Optional.ofNullable(node);
        if (nodel.isPresent()) {
            nodel.get().color = RED;
        }
    }

    public void setBlack(RBNode<T> node) {
        Optional<RBNode<T>> nodel = Optional.ofNullable(node);
        if (nodel.isPresent()) {
            nodel.get().color = BLACK;

        }
    }

    public boolean isRed(RBNode<T> node) {
        Optional<RBNode<T>> nodel = Optional.ofNullable(node);
        return nodel.isPresent() ? (nodel.get().color.equals(RED) ? true : false) : false;
    }

    public boolean isBlack(RBNode<T> node) {
        Optional<RBNode<T>> nodel = Optional.ofNullable(node);
        return nodel.isPresent() ? (nodel.get().color.equals(BLACK) ? true : false) : false;
    }


    private void leftRotate(RBNode<T> x) {
        RBNode<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else {
            if (x == x.parent.left) {
                x.parent.left = y;

            } else {
                x.parent.right = y;
            }
        }
        y.left = x;
        x.parent = y;

    }

    private void rightRotate(RBNode<T> y) {
        RBNode<T> x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        x.parent = y.parent;
        if (y.parent == null) {
            this.root = x;
        } else {
            if (y == y.parent.left) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }

        x.right = y;
        y.parent = x;
    }

    public void insert(T key) {
        RBNode<T> node = new RBNode<>(true, key, null, null, null);
        if (node != null) {
            insert(node);
        }
    }

    public void insert(RBNode<T> node) {
        RBNode<T> current = null;
        RBNode<T> x = this.root;

        while (x != null) {
            current = x;
            int cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = current;

        if (current != null) {
            int cmp = node.key.compareTo(current.key);
            if (cmp < 0) {
                current.left = node;
            } else {
                current.right = node;
            }
        } else {
            this.root = node;
        }
        insertFixUp(node);
    }

    private void insertFixUp(RBNode<T> node) {
        RBNode<T> parent, gparent;
        while (((parent = parentOf(node)) != null) && isRed(parent)) {
            gparent = parentOf(parent);
            if (parent == gparent.left) {
                RBNode<T> uncle = gparent.right;

                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(gparent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                if (node == parent.right) {
                    leftRotate(parent);
                    RBNode<T> temp = parent;
                    parent = node;
                    node = temp;
                }
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {
                RBNode<T> uncle = gparent.left;
                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                if (node == parent.left) {
                    rightRotate(parent);
                    RBNode<T> temp = parent;
                    parent = node;
                    node = temp;
                }
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        setBlack(root);

    }


    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int arrs[][] = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arrs[i][j] = arr[j][i];
            }
        }
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                System.out.print(arrs[i][j] + " ");
            }
            System.out.println();
        }
    }
}
