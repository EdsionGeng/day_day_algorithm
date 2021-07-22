package com.edison.algorithm.struct;


/**
 * @Description TODO
 * @Date 2020/6/2下午11:52
 * @Created by edsiongeng
 */
public class Tree234 {
    private Node234 root = new Node234();

    public Node234 getNextChild(Node234 currentNode, Integer nowDataItem) {
        int dataItemCount = currentNode.getDataItemCount();
        for (int i = 0; i < dataItemCount; i++) {
            if (nowDataItem < currentNode.dataItems[i]) {
                return currentNode.getChild(i);
            }
        }
        return currentNode.getChild(dataItemCount - 1);
    }

    public boolean exists(Integer dataItem) {
        Node234 currentNode = root;
        while (true) {
            if (currentNode.findDataItemIndex(dataItem) != -1) {
                return true;
            } else if (currentNode.isLeafNode()) {
                return false;
            } else {
                currentNode = getNextChild(currentNode, dataItem);
            }
        }
    }

    public void add(Integer dataItem) {
        Node234 currentNode = root;
        while (true) {
            if (currentNode.isFull()) {
                // 当前节点满了,分裂当前节点
                split(currentNode);
                currentNode = currentNode.getParent();
                currentNode = getNextChild(currentNode, dataItem);
            } else if (currentNode.isLeafNode()) {
                break;
            } else {
                currentNode = getNextChild(currentNode, dataItem);
            }
        }
        currentNode.insertItem(dataItem);

    }

    // 分裂节点
    public void split(Node234 currentNode) {
        // 定义从左到右 第二个数据项 和 第三个数据项
        Integer item, rightItem;
        // 定义父节点 ,以及最右侧两个子节点
        Node234 parent, child3, child4;
        int itemIndex;
        // 记录当前节点第三个数据项,并删除
        rightItem = currentNode.removeDataItem();
        // 记录当前节点第二个数据项,并删除
        item = currentNode.removeDataItem();
        // 记录当前节点第三个子节点,并删除
        child3 = currentNode.removeNode(2);
        // 记录当前节点第四个子节点,并删除
        child4 = currentNode.removeNode(3);
        // 创建分裂节点兄弟节点
        Node234 brotherNode = new Node234();
        // 分裂节点的最大数据项作为兄弟节点的数据下个
        brotherNode.insertItem(rightItem);
        // 分裂节点的第三个和第四个子节点作为兄弟节点的子节点
        brotherNode.connectChild(0, child3);
        brotherNode.connectChild(1, child4);
        // 开始分裂
        if (currentNode == root) {
            // 根节点分裂情况,创建新的根节点,原根节点作为新根节点的子节点,并记录分裂节点的父节点
            root = new Node234();
            parent = root;
            root.connectChild(0, currentNode);
        } else {
            // 记录分裂节点的父节点
            parent = currentNode.getParent();
        }
        // 将要分裂节点的的中间数据项插入到父节点中 并且获取到插入的索引
        itemIndex = parent.insertItem(item);
        // 获取父节点中数据项的个数
        int dataItemCount = parent.getDataItemCount();
        // 循环根据
        for (int j = dataItemCount - 1; j > itemIndex; j--) { //
            Node234 temp = parent.removeNode(j); // 父节点和要拆分的接待你断开连接
            parent.connectChild(j + 1, temp); // 父节点和要拆分的原节点重新连接 位置为原要拆分节点的中间的数据项在父节点中位置的左边
        }
        parent.connectChild(itemIndex + 1, brotherNode); // 然后在原要拆分节点新的位置的右边插入新的右边节点
    }

    // 打印一整棵树
    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    // 打印树 传入要从那个节开始打 从那层开始的 哪个节点开始的 前序遍历
    private void recDisplayTree(Node234 thisNode, int level, int childNumber) {

    }

    /**
     * 一个节点最多有三个数据项
     * 一个节点最多有四个子节点
     */
    public class Node234 {
        //节点子节点数量
        private static final int CHILD_NODE_COUNT = 4;
        //节点数据项个数
        private int dataItemCount;
        //父节点
        private Node234 parent;
        //子节点
        private Node234[] children = new Node234[CHILD_NODE_COUNT];
        //节点数据项
        private Integer[] dataItems = new Integer[CHILD_NODE_COUNT - 1];

        public Node234() {
            this.dataItemCount = 0;
        }

        // 判断当前节点是否已满
        public boolean isFull() {

            return (dataItemCount == CHILD_NODE_COUNT - 1);
        }

        // 获取父节点
        public Node234 getParent() {

            return parent;
        }

        // 获取指定位置的子节点
        public Node234 getChild(int childIndex) {

            return children[childIndex];
        }

        // 判断节点是否为叶子节点
        public boolean isLeafNode() {

            return children[0] == null;
        }

        // 获取节点的数据项个数
        public int getDataItemCount() {

            return dataItemCount;
        }

        // 获取指定位置的数据项
        public int getDataItem(int dataItemIndex) {

            return dataItems[dataItemIndex];
        }

        // 连接子节点
        public void connectChild(int childIndex, Node234 child) {
            if (child != null) {
                children[childIndex] = child;
                child.parent = this;
            }
        }

        // 去掉子节点
        public Node234 removeNode(int childIndex) {
            Node234 removeNode = children[childIndex];
            children[childIndex] = null;
            return removeNode;
        }

        // 查找具体数据项在数据项数组中的索引位置
        public int findDataItemIndex(Integer dataItem) {
            for (int i = 0; i < CHILD_NODE_COUNT - 1; i++) {
                if (dataItems[i] == null) {
                    break;
                } else if (dataItems[i].equals(dataItem)) {
                    return i;
                }
            }
            return -1;
        }

        //插入数据项
        public int insertItem(Integer newDataItem) {
            dataItemCount++;
            for (int i = CHILD_NODE_COUNT - 2; i >= 0; i--) {
                if (dataItems[i] == null) {
                    continue;
                }
                if (newDataItem < dataItems[i]) {
                    dataItems[i + 1] = dataItems[i];
                } else {
                    dataItems[i + 1] = newDataItem;
                    return i + 1;
                }
            }
            dataItems[0] = newDataItem;
            return 0;
        }

        //删除大数据项
        public Integer removeDataItem() {
            Integer removeDataItem = dataItems[dataItemCount - 1];
            dataItems[dataItemCount - 1] = null;
            dataItemCount--;
            return removeDataItem;
        }

        // 打印节点
        public void displayNode() {
            for (int i = 0; i < dataItemCount; i++) {
                System.out.println("/" + dataItems[i]);
            }
            System.out.println("/");
        }
    }
}
