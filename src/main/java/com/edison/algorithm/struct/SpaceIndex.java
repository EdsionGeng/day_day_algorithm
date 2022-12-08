package com.edison.algorithm.struct;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//https://github.com/mourner/rbush
public class SpaceIndex {

    public static class Constants {
        public static final int MAX_NUMBER_OF_ENTRIES_IN_NODE = 20;// 结点中的最大条目数
        public static final int MIN_NUMBER_OF_ENTRIES_IN_NODE = 8;// 结点中的最小条目数

        public static final int RTDataNode_Dimension = 2;

        /** Available RTree variants. */ // 树的类型常量
        public static final int RTREE_LINEAR = 0; // 线性
        public static final int RTREE_QUADRATIC = 1; // 二维
        public static final int RTREE_EXPONENTIAL = 2; // 多维
        public static final int RSTAR = 3; // 星型

        public static final int NIL = -1;
        public static final RTNode NULL = null;
    }
    /**
     * @ClassName RTree
     * @Description
     */
    @Data
    public class RTree {
        private RTNode root; // 根节点
        private int tree_type; // 树类型
        private int nodeCapacity = -1; // 结点容量
        private float fillFactor = -1; // 结点填充因子 ，用于计算每个结点最小条目个数
        private int dimension; // 维度

        public RTree(int capacity, float fillFactor, int type, int dimension) {
            this.fillFactor = fillFactor;
            tree_type = type;
            nodeCapacity = capacity;
            this.dimension = dimension;
            root = new RTDataNode(this, Constants.NULL); // 根节点的父节点为NULL
        }

        /**
         * @return RTree的维度
         */
        public int getDimension() {
            return dimension;
        }

        /** 设置跟节点 */
        public void setRoot(RTNode root) {
            this.root = root;
        }

        /**
         * @return 填充因子
         */
        public float getFillFactor() {
            return fillFactor;
        }

        /**
         * @return 返回结点容量
         */
        public int getNodeCapacity() {
            return nodeCapacity;
        }

        /**
         * @return 返回树的类型
         */
        public int getTreeType() {
            return tree_type;
        }

        /**
         * --> 向Rtree中插入Rectangle 1、先找到合适的叶节点 2、再向此叶节点中插入
         *
         * @param rectangle
         */
        public boolean insert(Rectangle rectangle) {
            if (rectangle == null)
                throw new IllegalArgumentException("Rectangle cannot be null.");

            if (rectangle.getHigh().getDimension() != getDimension()) // 矩形维度与树的维度不一致
            {
                throw new IllegalArgumentException("Rectangle dimension different than RTree dimension.");
            }

            RTDataNode leaf = root.chooseLeaf(rectangle);

            return leaf.insert(rectangle);
        }

        /**
         * 从R树中删除Rectangle
         * <p>
         * 1、寻找包含记录的结点--调用算法findLeaf()来定位包含此记录的叶子结点L，如果没有找到则算法终止。<br>
         * 2、删除记录--将找到的叶子结点L中的此记录删除<br>
         * 3、调用算法condenseTree<br>
         *
         * @param rectangle
         * @return
         */
        public int delete(Rectangle rectangle) {
            if (rectangle == null) {
                throw new IllegalArgumentException("Rectangle cannot be null.");
            }

            if (rectangle.getHigh().getDimension() != getDimension()) {
                throw new IllegalArgumentException("Rectangle dimension different than RTree dimension.");
            }

            RTDataNode leaf = root.findLeaf(rectangle);

            if (leaf != null) {
                return leaf.delete(rectangle);
            }

            return -1;
        }

        /**
         * 从给定的结点root开始遍历所有的结点
         *
         * @param root
         * @return 所有遍历的结点集合
         */
        public List<RTNode> traversePostOrder(RTNode root) {
            if (root == null)
                throw new IllegalArgumentException("Node cannot be null.");

            List<RTNode> list = new ArrayList<RTNode>();
            list.add(root);

            if (!root.isLeaf()) {
                for (int i = 0; i < root.usedSpace; i++) {
                    List<RTNode> a = traversePostOrder(((RTDirNode) root).getChild(i));
                    for (int j = 0; j < a.size(); j++) {
                        list.add(a.get(j));
                    }
                }
            }

            return list;
        }

//        public static void main(String[] args) throws Exception {
//            // 结点容量：4、填充因子：0.4、树类型：二维
//            RTree tree = new RTree(4, 0.4f, Constants.RTREE_QUADRATIC, 2);
//            // 每一行的四个数构成两个点（一个矩形）
//            float[] f = { 5, 30, 25, 35, 15, 38, 23, 50, 10, 23, 30, 28, 13, 10, 18, 15, 23, 10, 28, 20, 28, 30, 33, 40, 38,
//                    13, 43, 30, 35, 37, 40, 43, 45, 8, 50, 50, 23, 55, 28, 70, 10, 65, 15, 70, 10, 58, 20, 63, };
//
//            // 插入结点
//            for (int i = 0; i < f.length;) {
//                Point p1 = new Point(new float[] { f[i++], f[i++] });
//                Point p2 = new Point(new float[] { f[i++], f[i++] });
//                final Rectangle rectangle = new Rectangle(p1, p2);
//                tree.insert(rectangle);
//
//                Rectangle[] rectangles = tree.root.datas;
//                System.out.println("level:" + tree.root.level);
//                for (int j = 0; j < rectangles.length; j++)
//                    System.out.println(rectangles[j]);
//            }
//            System.out.println("---------------------------------");
//            System.out.println("Insert finished.");
//
//            // 删除结点
//            System.out.println("---------------------------------");
//            System.out.println("Begin delete.");
//
//            for (int i = 0; i < f.length;) {
//                Point p1 = new Point(new float[] { f[i++], f[i++] });
//                Point p2 = new Point(new float[] { f[i++], f[i++] });
//                final Rectangle rectangle = new Rectangle(p1, p2);
//                tree.delete(rectangle);
//
//                Rectangle[] rectangles = tree.root.datas;
//                System.out.println(tree.root.level);
//                for (int j = 0; j < rectangles.length; j++)
//                    System.out.println(rectangles[j]);
//            }
//
//            System.out.println("---------------------------------");
//            System.out.println("Delete finished.");
//
//            Rectangle[] rectangles = tree.root.datas;
//            for (int i = 0; i < rectangles.length; i++)
//                System.out.println(rectangles[i]);
//
//        }

    }

    /**
     * @ClassName RTDirNode
     * @Description 非叶节点
     */
    public class RTDirNode extends RTNode {
        /**
         * 孩子结点集
         */
        protected List<RTNode> children;

        // 构造函数
        public RTDirNode(RTree rtree, RTNode parent, int level) {
            super(rtree, parent, level); // 调用父类的构造函数
            children = new ArrayList<RTNode>(); // 新建一个RTNode类型的结点数组
        }

        /**
         * @param index
         * @return 对应索引下的孩子结点
         */
        public RTNode getChild(int index) {
            return children.get(index);
        }

        @Override
        /*-->选择叶子结点*/
        public RTDataNode chooseLeaf(Rectangle rectangle) {
            int index;

            switch (rtree.getTreeType()) {
                case Constants.RTREE_LINEAR:

                case Constants.RTREE_QUADRATIC:

                case Constants.RTREE_EXPONENTIAL:
                    index = findLeastEnlargement(rectangle); // 获得面积增量最小的结点的索引
                    break;
                case Constants.RSTAR:
                    if (level == 1)// 即此结点指向叶节点
                    {
                        index = findLeastOverlap(rectangle); // 获得最小重叠面积的结点的索引
                    } else {
                        index = findLeastEnlargement(rectangle); // 获得面积增量最小的结点的索引
                    }
                    break;

                default:
                    throw new IllegalStateException("Invalid tree type.");
            }

            insertIndex = index;// 记录插入路径的索引

            return getChild(index).chooseLeaf(rectangle); // 非叶子节点的chooseLeaf（）实现递归调用
        }

        /**
         * @param rectangle
         * @return -->返回最小重叠面积的结点的索引， 如果重叠面积相等则选择加入此Rectangle后面积增量更小的，
         *         如果面积增量还相等则选择自身面积更小的
         */
        private int findLeastOverlap(Rectangle rectangle) {
            float overlap = Float.POSITIVE_INFINITY;
            int sel = -1;

            for (int i = 0; i < usedSpace; i++) {
                RTNode node = getChild(i);
                float ol = 0; // 用于记录每个孩子的datas数据与传入矩形的重叠面积之和

                for (int j = 0; j < node.datas.length; j++) {
                    // 将传入矩形与各个矩形重叠的面积累加到ol中，得到重叠的总面积
                    ol += rectangle.intersectingArea(node.datas[j]);
                }
                if (ol < overlap) {
                    overlap = ol;// 记录重叠面积最小的
                    sel = i;// 记录第几个孩子的索引
                }
                // 如果重叠面积相等则选择加入此Rectangle后面积增量更小的,如果面积增量还相等则选择自身面积更小的
                else if (ol == overlap) {
                    double area1 = datas[i].getUnionRectangle(rectangle).getArea() - datas[i].getArea();
                    double area2 = datas[sel].getUnionRectangle(rectangle).getArea() - datas[sel].getArea();

                    if (area1 == area2) {
                        sel = (datas[sel].getArea() <= datas[i].getArea()) ? sel : i;
                    } else {
                        sel = (area1 < area2) ? i : sel;
                    }
                }
            }
            return sel;
        }

        /**
         * @param rectangle
         * @return -->面积增量最小的结点的索引，如果面积增量相等则选择自身面积更小的
         */
        private int findLeastEnlargement(Rectangle rectangle) {
            double area = Double.POSITIVE_INFINITY; // double类型的正无穷
            int sel = -1;

            for (int i = 0; i < usedSpace; i++) {
                // 增量enlargement = 包含（datas[i]里面存储的矩形与查找的矩形）的最小矩形的面积 -
                // datas[i]里面存储的矩形的面积
                double enlargement = datas[i].getUnionRectangle(rectangle).getArea() - datas[i].getArea();
                if (enlargement < area) {
                    area = enlargement; // 记录增量
                    sel = i; // 记录引起增量的【包含（datas[i]里面存储的矩形与查找的矩形）的最小矩形】里面的datas[i]的索引
                } else if (enlargement == area) {
                    sel = (datas[sel].getArea() < datas[i].getArea()) ? sel : i;
                }
            }

            return sel;
        }

        /**
         * --> 插入新的Rectangle后从插入的叶节点开始向上调整RTree，直到根节点
         *
         * @param node1
         *            引起需要调整的孩子结点
         * @param node2
         *            分裂的结点，若未分裂则为null
         */
        public void adjustTree(RTNode node1, RTNode node2) {
            // 先要找到指向原来旧的结点（即未添加Rectangle之前）的条目的索引
            datas[insertIndex] = node1.getNodeRectangle();// 先用node1覆盖原来的结点
            children.set(insertIndex, node1);// 替换旧的结点

            if (node2 != null) {
                insert(node2);// 插入新的结点

            }
            // 还没到达根节点
            else if (!isRoot()) {
                RTDirNode parent = (RTDirNode) getParent();
                parent.adjustTree(this, null);// 向上调整直到根节点
            }
        }

        /**
         * -->非叶子节点插入
         *
         * @param node
         * @return 如果结点需要分裂则返回true
         */
        protected boolean insert(RTNode node) {
            // 已用结点小于树的节点容量，不需分裂，只需插入以及调整树
            if (usedSpace < rtree.getNodeCapacity()) {
                datas[usedSpace++] = node.getNodeRectangle();
                children.add(node);// 新加的
                node.parent = this;// 新加的
                RTDirNode parent = (RTDirNode) getParent();
                if (parent != null) // 不是根节点
                {
                    parent.adjustTree(this, null);
                }
                return false;
            } else {// 非叶子结点需要分裂
                RTDirNode[] a = splitIndex(node);
                RTDirNode n = a[0];
                RTDirNode nn = a[1];

                if (isRoot()) {
                    // 新建根节点，层数加1
                    RTDirNode newRoot = new RTDirNode(rtree, Constants.NULL, level + 1);

                    // 把两个分裂的结点n和nn添加到根节点
                    newRoot.addData(n.getNodeRectangle());
                    newRoot.addData(nn.getNodeRectangle());

                    newRoot.children.add(n);
                    newRoot.children.add(nn);

                    // 设置两个分裂的结点n和nn的父节点
                    n.parent = newRoot;
                    nn.parent = newRoot;

                    // 最后设置rtree的根节点
                    rtree.setRoot(newRoot);// 新加的
                } else {
                    // 如果不是根结点，向上调整树
                    RTDirNode p = (RTDirNode) getParent();
                    p.adjustTree(n, nn);
                }
            }
            return true;
        }

        /**
         * -->非叶子结点的分裂
         *
         * @param node
         * @return
         */
        private RTDirNode[] splitIndex(RTNode node) {
            int[][] group = null;
            switch (rtree.getTreeType()) {
                case Constants.RTREE_LINEAR:
                    break;
                case Constants.RTREE_QUADRATIC:
                    group = quadraticSplit(node.getNodeRectangle());
                    children.add(node);// 新加的
                    node.parent = this;// 新加的
                    break;
                case Constants.RTREE_EXPONENTIAL:
                    break;
                case Constants.RSTAR:
                    break;
                default:
                    throw new IllegalStateException("Invalid tree type.");
            }
            // 新建两个非叶子节点
            RTDirNode index1 = new RTDirNode(rtree, parent, level);
            RTDirNode index2 = new RTDirNode(rtree, parent, level);

            int[] group1 = group[0];
            int[] group2 = group[1];
            // 为index1添加数据和孩子
            for (int i = 0; i < group1.length; i++) {
                index1.addData(datas[group1[i]]);
                index1.children.add(this.children.get(group1[i]));// 新加的
                // 让index1成为其父节点
                this.children.get(group1[i]).parent = index1;// 新加的
            }
            for (int i = 0; i < group2.length; i++) {
                index2.addData(datas[group2[i]]);
                index2.children.add(this.children.get(group2[i]));// 新加的
                this.children.get(group2[i]).parent = index2;// 新加的
            }
            return new RTDirNode[] { index1, index2 };
        }

        @Override
        // 寻找叶子
        protected RTDataNode findLeaf(Rectangle rectangle) {
            for (int i = 0; i < usedSpace; i++) {
                if (datas[i].enclosure(rectangle)) {
                    deleteIndex = i;// 记录搜索路径
                    RTDataNode leaf = children.get(i).findLeaf(rectangle); // 递归查找
                    if (leaf != null)
                        return leaf;
                }
            }
            return null;
        }

    }
    /**
     * @ClassName RTDataNode
     * @Description 叶子结点
     */
    public class RTDataNode extends RTNode {

        public RTDataNode(RTree rTree, RTNode parent) {
            super(rTree, parent, 0);
        }

        /**
         * -->叶节点中插入Rectangle 在叶节点中插入Rectangle，插入后如果其父节点不为空则需要向上调整树直到根节点；
         * 如果其父节点为空，则是从根节点插入 若插入Rectangle之后超过结点容量则需要分裂结点 【注】插入数据后，从parent处开始调整数据
         *
         * @param rectangle
         * @return
         */
        public boolean insert(Rectangle rectangle) {
            if (usedSpace < rtree.getNodeCapacity()) // 已用节点小于节点容量
            {
                datas[usedSpace++] = rectangle;
                RTDirNode parent = (RTDirNode) getParent();

                if (parent != null)
                    // 调整树，但不需要分裂节点，因为 节点小于节点容量，还有空间
                    parent.adjustTree(this, null);
                return true;

            }
            // 超过结点容量
            else {
                RTDataNode[] splitNodes = splitLeaf(rectangle);
                RTDataNode l = splitNodes[0];
                RTDataNode ll = splitNodes[1];

                if (isRoot()) {
                    // 根节点已满，需要分裂。创建新的根节点
                    RTDirNode rDirNode = new RTDirNode(rtree, Constants.NULL, level + 1);
                    rtree.setRoot(rDirNode);
                    // getNodeRectangle()返回包含结点中所有条目的最小Rectangle
                    rDirNode.addData(l.getNodeRectangle());
                    rDirNode.addData(ll.getNodeRectangle());

                    ll.parent = rDirNode;
                    l.parent = rDirNode;

                    rDirNode.children.add(l);
                    rDirNode.children.add(ll);

                } else {// 不是根节点
                    RTDirNode parentNode = (RTDirNode) getParent();
                    parentNode.adjustTree(l, ll);
                }

            }
            return true;
        }

        /**
         * 叶子节点的分裂 插入Rectangle之后超过容量需要分裂
         *
         * @param rectangle
         * @return
         */
        public RTDataNode[] splitLeaf(Rectangle rectangle) {
            int[][] group = null;

            switch (rtree.getTreeType()) {
                case Constants.RTREE_LINEAR:
                    break;
                case Constants.RTREE_QUADRATIC:
                    group = quadraticSplit(rectangle);
                    break;
                case Constants.RTREE_EXPONENTIAL:
                    break;
                case Constants.RSTAR:
                    break;
                default:
                    throw new IllegalArgumentException("Invalid tree type.");
            }

            RTDataNode l = new RTDataNode(rtree, parent);
            RTDataNode ll = new RTDataNode(rtree, parent);

            int[] group1 = group[0];
            int[] group2 = group[1];

            for (int i = 0; i < group1.length; i++) {
                l.addData(datas[group1[i]]);
            }

            for (int i = 0; i < group2.length; i++) {
                ll.addData(datas[group2[i]]);
            }
            return new RTDataNode[] { l, ll };
        }

        @Override
        public RTDataNode chooseLeaf(Rectangle rectangle) {
            insertIndex = usedSpace;// 记录插入路径的索引
            return this;
        }

        /**
         * 从叶节点中删除此条目rectangle
         * <p>
         * 先删除此rectangle，再调用condenseTree()返回删除结点的集合，把其中的叶子结点中的每个条目重新插入；
         * 非叶子结点就从此结点开始遍历所有结点，然后把所有的叶子结点中的所有条目全部重新插入
         *
         * @param rectangle
         * @return
         */
        protected int delete(Rectangle rectangle) {
            for (int i = 0; i < usedSpace; i++) {
                if (datas[i].equals(rectangle)) {
                    deleteData(i);
                    // 用于存储被删除的结点包含的条目的链表Q
                    List<RTNode> deleteEntriesList = new ArrayList<RTNode>();
                    condenseTree(deleteEntriesList);

                    // 重新插入删除结点中剩余的条目
                    for (int j = 0; j < deleteEntriesList.size(); j++) {
                        RTNode node = deleteEntriesList.get(j);
                        if (node.isLeaf())// 叶子结点，直接把其上的数据重新插入
                        {
                            for (int k = 0; k < node.usedSpace; k++) {
                                rtree.insert(node.datas[k]);
                            }
                        } else {// 非叶子结点，需要先后序遍历出其上的所有结点
                            List<RTNode> traverseNodes = rtree.traversePostOrder(node);

                            // 把其中的叶子结点中的条目重新插入
                            for (int index = 0; index < traverseNodes.size(); index++) {
                                RTNode traverseNode = traverseNodes.get(index);
                                if (traverseNode.isLeaf()) {
                                    for (int t = 0; t < traverseNode.usedSpace; t++) {
                                        rtree.insert(traverseNode.datas[t]);
                                    }
                                }
                            }

                        }
                    }

                    return deleteIndex;
                } // end if
            } // end for
            return -1;
        }

        @Override
        protected RTDataNode findLeaf(Rectangle rectangle) {
            for (int i = 0; i < usedSpace; i++) {
                if (datas[i].enclosure(rectangle)) {
                    deleteIndex = i;// 记录搜索路径
                    return this;
                }
            }
            return null;
        }

    }


    /**
     * @ClassName Point
     * @Description n维空间中的点，所有的维度被存储在一个float数组中
     */
    public class Point implements Cloneable {
        private float[] data;

        public Point(float[] data) {
            if (data == null) {
                throw new IllegalArgumentException("Coordinates cannot be null."); // ★坐标不能为空
            }
            if (data.length < 2) {
                throw new IllegalArgumentException("Point dimension should be greater than 1."); // ★点的维度必须大于1
            }

            this.data = new float[data.length];
            System.arraycopy(data, 0, this.data, 0, data.length); // 复制数组
        }

        public Point(int[] data) {
            if (data == null) {
                throw new IllegalArgumentException("Coordinates cannot be null."); // ★坐标不能为空
            }
            if (data.length < 2) {
                throw new IllegalArgumentException("Point dimension should be greater than 1."); // ★点的维度必须大于1
            }

            this.data = new float[data.length];
            for (int i = 0; i < data.length; i++) {
                this.data[i] = data[i]; // 复制数组
            }
        }

        @Override // 重写clone接口
        protected Object clone() {
            float[] copy = new float[data.length];
            System.arraycopy(data, 0, copy, 0, data.length);
            return new Point(copy);
        }

        @Override // 重写tostring（）方法
        public String toString() {
            StringBuffer sBuffer = new StringBuffer("(");

            for (int i = 0; i < data.length - 1; i++) {
                sBuffer.append(data[i]).append(",");
            }

            sBuffer.append(data[data.length - 1]).append(")"); // 最后一位数据后面不再添加逗号，追加放在循环外面

            return sBuffer.toString();
        }

        /*
         * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★ ★ 测试 ★
         * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
         */
//        public static void main(String[] args) {
//            float[] test = { 1.2f, 2f, 34f };
//            Point point1 = new Point(test);
//            System.out.println(point1);
//
//            int[] test2 = { 1, 2, 3, 4 };
//            point1 = new Point(test2);
//            System.out.println(point1);
//
//            int[] test3 = { 11, 22 }; // 二维的点
//            point1 = new Point(test3);
//            System.out.println(point1);
//        }

        /**
         * @return 返回Point的维度
         */
        public int getDimension() {
            return data.length;
        }

        /**
         * @param index
         * @return 返回Point坐标第i位的float值
         */
        public float getFloatCoordinate(int index) {
            return data[index];
        }

        /**
         * @param index
         * @return 返回Point坐标第i位的int值
         */
        public int getIntCoordinate(int index) {
            return (int) data[index];
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) // 如果obj是point的实例
            {
                Point point = (Point) obj;

                if (point.getDimension() != getDimension()) // 维度相同的点才能比较
                    throw new IllegalArgumentException("Points must be of equal dimensions to be compared.");

                for (int i = 0; i < getDimension(); i++) {
                    if (getFloatCoordinate(i) != point.getFloatCoordinate(i))
                        return false;
                }
            }

            if (!(obj instanceof Point))
                return false;

            return true;
        }
    }


    /**
     * 外包矩形
     *
     * @ClassName Rectangle
     * @Description
     */
    public class Rectangle implements Cloneable // 继承克隆接口
    {
        private Point low; // 左下角的点
        private Point high; // 右上角的点

        public Rectangle(Point p1, Point p2) // 初始化时，第一个参数为左下角，第二个参数为右上角
        {
            if (p1 == null || p2 == null) // 点对象不能为空
            {
                throw new IllegalArgumentException("Points cannot be null.");
            }
            if (p1.getDimension() != p2.getDimension()) // 点的维度应该相等
            {
                throw new IllegalArgumentException("Points must be of same dimension.");
            }
            // 先左下角后右上角
            for (int i = 0; i < p1.getDimension(); i++) {
                if (p1.getFloatCoordinate(i) > p2.getFloatCoordinate(i)) {
                    throw new IllegalArgumentException("坐标点为先左下角后右上角");
                }
            }
            low = (Point) p1.clone();
            high = (Point) p2.clone();
        }

        /**
         * 返回Rectangle左下角的Point
         *
         * @return Point
         */
        public Point getLow() {
            return (Point) low.clone();
        }

        /**
         * 返回Rectangle右上角的Point
         *
         * @return Point
         */
        public Point getHigh() {
            return high;
        }

        /**
         * @param rectangle
         * @return 包围两个Rectangle的最小Rectangle
         */
        public Rectangle getUnionRectangle(Rectangle rectangle) {
            if (rectangle == null) // 矩形不能为空
                throw new IllegalArgumentException("Rectangle cannot be null.");

            if (rectangle.getDimension() != getDimension()) // 矩形维度必须相同
            {
                throw new IllegalArgumentException("Rectangle must be of same dimension.");
            }

            float[] min = new float[getDimension()];
            float[] max = new float[getDimension()];

            for (int i = 0; i < getDimension(); i++) {
                // 第一个参数是当前矩形的坐标值，第二个参数是传入的参数的矩形的坐标值
                min[i] = Math.min(low.getFloatCoordinate(i), rectangle.low.getFloatCoordinate(i));
                max[i] = Math.max(high.getFloatCoordinate(i), rectangle.high.getFloatCoordinate(i));
            }

            return new Rectangle(new Point(min), new Point(max));
        }

        /**
         * @return 返回Rectangle的面积
         */
        public float getArea() {
            float area = 1;
            for (int i = 0; i < getDimension(); i++) {
                area *= high.getFloatCoordinate(i) - low.getFloatCoordinate(i);
            }

            return area;
        }

        /**
         * @param rectangles
         * @return 包围一系列Rectangle的最小Rectangle
         */
        public  Rectangle getUnionRectangle(Rectangle[] rectangles) {
            if (rectangles == null || rectangles.length == 0)
                throw new IllegalArgumentException("Rectangle array is empty.");

            Rectangle r0 = (Rectangle) rectangles[0].clone();
            for (int i = 1; i < rectangles.length; i++) {
                r0 = r0.getUnionRectangle(rectangles[i]); // 获得包裹矩形r0与r[i]的最小边界的矩形再赋值给r0
            }

            return r0; // 返回包围一系列Rectangle的最小Rectangle
        }

        @Override
        // 重写clone()函数
        protected Object clone() {
            Point p1 = (Point) low.clone();
            Point p2 = (Point) high.clone();
            return new Rectangle(p1, p2);
        }

        @Override
        // 重写tostring()方法
        public String toString() {
            return "Rectangle Low:" + low + " High:" + high;
        }

//        /*
//         * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★ ★ 测试 ★
//         * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//         */
//        public static void main(String[] args) {
//            // 新建两point再根据两个point构建一个Rectangle
//            float[] f1 = { 1.3f, 2.4f };
//            float[] f2 = { 3.4f, 4.5f };
//            Point p1 = new Point(f1);
//            Point p2 = new Point(f2);
//            Rectangle rectangle = new Rectangle(p1, p2);
//            System.out.println(rectangle);
//            // Point point = rectangle.getHigh();
//            // point = p1;
//            // System.out.println(rectangle);
//
//            float[] f_1 = { -2f, 0f };
//            float[] f_2 = { 0f, 2f };
//            float[] f_3 = { -2f, 1f };
//            float[] f_4 = { 3f, 3f };
//            float[] f_5 = { 1f, 0f };
//            float[] f_6 = { 2f, 4f };
//            p1 = new Point(f_1);
//            p2 = new Point(f_2);
//            Point p3 = new Point(f_3);
//            Point p4 = new Point(f_4);
//            Point p5 = new Point(f_5);
//            Point p6 = new Point(f_6);
//            Rectangle re1 = new Rectangle(p1, p2);
//            Rectangle re2 = new Rectangle(p3, p4);
//            Rectangle re3 = new Rectangle(p5, p6);
//            // Rectangle re4 = new Rectangle(p3, p4); //输入要先左下角，再右上角
//
//            System.out.println(re1.isIntersection(re2));
//            System.out.println(re1.isIntersection(re3));
//            System.out.println(re1.intersectingArea(re2));
//            System.out.println(re1.intersectingArea(re3));
//        }

        /**
         * 两个Rectangle相交的面积
         *
         * @param rectangle
         *            Rectangle
         * @return float
         */
        public float intersectingArea(Rectangle rectangle) {
            if (!isIntersection(rectangle)) // 如果不相交，相交面积为0
            {
                return 0;
            }

            float ret = 1;
            // 循环一次，得到一个维度的相交的边，累乘多个维度的相交的边，即为面积
            for (int i = 0; i < rectangle.getDimension(); i++) {
                float l1 = this.low.getFloatCoordinate(i);
                float h1 = this.high.getFloatCoordinate(i);
                float l2 = rectangle.low.getFloatCoordinate(i);
                float h2 = rectangle.high.getFloatCoordinate(i);

                // rectangle1在rectangle2的左边
                if (l1 <= l2 && h1 <= h2) {
                    ret *= (h1 - l1) - (l2 - l1);
                }
                // rectangle1在rectangle2的右边
                else if (l1 >= l2 && h1 >= h2) {
                    ret *= (h2 - l2) - (l1 - l2);
                }
                // rectangle1在rectangle2里面
                else if (l1 >= l2 && h1 <= h2) {
                    ret *= h1 - l1;
                }
                // rectangle1包含rectangle2
                else if (l1 <= l2 && h1 >= h2) {
                    ret *= h2 - l2;
                }
            }
            return ret;
        }

        /**
         * @param rectangle
         * @return 判断两个Rectangle是否相交
         */
        public boolean isIntersection(Rectangle rectangle) {
            if (rectangle == null)
                throw new IllegalArgumentException("Rectangle cannot be null.");

            if (rectangle.getDimension() != getDimension()) // 进行判断的两个矩形维度必须相等
            {
                throw new IllegalArgumentException("Rectangle cannot be null.");
            }

            for (int i = 0; i < getDimension(); i++) {
                /*
                 * 当前矩形左下角的坐标值大于传入矩形右上角的坐标值 || 当前矩形右上角角的坐标值小于传入矩形左下角的坐标值
                 */
                if (low.getFloatCoordinate(i) > rectangle.high.getFloatCoordinate(i)
                        || high.getFloatCoordinate(i) < rectangle.low.getFloatCoordinate(i)) {
                    return false; // 没有相交
                }
            }
            return true;
        }

        /**
         * @return 返回Rectangle的维度
         */
        private int getDimension() {
            return low.getDimension();
        }

        /**
         * 判断rectangle是否被包围
         *
         * @param rectangle
         * @return
         */
        public boolean enclosure(Rectangle rectangle) {
            if (rectangle == null) // 矩形不能为空
                throw new IllegalArgumentException("Rectangle cannot be null.");

            if (rectangle.getDimension() != getDimension()) // 判断的矩形必须维度相同
                throw new IllegalArgumentException("Rectangle dimension is different from current dimension.");
            // 只要传入的rectangle有一个维度的坐标越界了就不被包含
            for (int i = 0; i < getDimension(); i++) {
                if (rectangle.low.getFloatCoordinate(i) < low.getFloatCoordinate(i)
                        || rectangle.high.getFloatCoordinate(i) > high.getFloatCoordinate(i))
                    return false;
            }
            return true;
        }

        @Override
        // 重写equals方法
        public boolean equals(Object obj) {
            if (obj instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) obj;
                if (low.equals(rectangle.getLow()) && high.equals(rectangle.getHigh()))
                    return true;
            }
            return false;
        }
    }



    /**
     * @ClassName RTNode
     * @Description
     */
    public abstract class RTNode {
        protected RTree rtree; // 结点所在的树
        protected int level; // 结点所在的层
        protected Rectangle[] datas; // 相当于条目
        protected RTNode parent; // 父节点
        protected int usedSpace; // 结点已用的空间
        protected int insertIndex; // 记录插入的搜索路径索引
        protected int deleteIndex; // 记录删除的查找路径索引

        /**
         * 构造函数初始化
         */
        public RTNode(RTree rtree, RTNode parent, int level) {
            this.rtree = rtree;
            this.parent = parent;
            this.level = level;
            datas = new Rectangle[rtree.getNodeCapacity() + 1];// 多出的一个用于结点分裂
            usedSpace = 0;
        }

        /**
         * @return 返回父节点
         */
        public RTNode getParent() {
            return parent;
        }

        /**
         * -->向结点中添加Rectangle，即添加条目
         *
         * @param rectangle
         */
        protected void addData(Rectangle rectangle) {
            // 如果节点已用空间==r树的节点容量
            if (usedSpace == rtree.getNodeCapacity()) {
                throw new IllegalArgumentException("Node is full.");
            }
            datas[usedSpace++] = rectangle;
        }

        /**
         * -->删除结点中的第i个条目
         *
         * @param i
         */
        protected void deleteData(int i) {
            if (datas[i + 1] != null) // 如果为中间节点（非尾节点），采用拷贝数组的方式链接条目
            {
                System.arraycopy(datas, i + 1, datas, i, usedSpace - i - 1);
                datas[usedSpace - 1] = null;
            } else // 如果为末尾节点，将节点置空
                datas[i] = null;
            // 删除之后已用节点自减
            usedSpace--;
        }

        /**
         * 压缩算法 叶节点L中刚刚删除了一个条目，如果这个结点的条目数太少下溢， 则删除该结点，同时将该结点中剩余的条目重定位到其他结点中。
         * 如果有必要，要逐级向上进行这种删除，调整向上传递的路径上的所有外包矩形，使其尽可能小，直到根节点。
         *
         * @param list
         *            存储删除结点中剩余条目
         */
        protected void condenseTree(List<RTNode> list) {
            if (isRoot()) {
                // 根节点只有一个条目了，即只有左孩子或者右孩子 ，
                // 将唯一条目删除，释放根节点，将原根节点唯一的孩子设置为新根节点
                if (!isLeaf() && usedSpace == 1) {
                    RTDirNode root = (RTDirNode) this;

                    RTNode child = root.getChild(0);
                    root.children.remove(this);
                    child.parent = null;
                    rtree.setRoot(child);

                }
            } else {
                RTNode parent = getParent();
                // 计算节点最小容量，用于判断是否引起下溢
                int min = Math.round(rtree.getNodeCapacity() * rtree.getFillFactor());
                if (usedSpace < min) {
                    parent.deleteData(parent.deleteIndex);// 其父节点中删除此条目
                    ((RTDirNode) parent).children.remove(this);
                    this.parent = null;
                    list.add(this);// 之前已经把数据删除了
                } else {
                    parent.datas[parent.deleteIndex] = getNodeRectangle();
                }
                parent.condenseTree(list);
            }
        }

        /**
         * 分裂结点的平方算法
         * <p>
         * 1、为两个组选择第一个条目--调用算法pickSeeds()来为两个组选择第一个元素，分别把选中的两个条目分配到两个组当中。<br>
         * 2、检查是否已经分配完毕，如果一个组中的条目太少，为避免下溢，将剩余的所有条目全部分配到这个组中，算法终止<br>
         * 3、调用pickNext来选择下一个进行分配的条目--计算把每个条目加入每个组之后面积的增量，选择两个组面积增量差最大的条目索引,
         * 如果面积增量相等则选择面积较小的组，若面积也相等则选择条目数更少的组<br>
         *
         * @param rectangle
         *            导致分裂的溢出Rectangle
         * @return 两个组中的条目的索引
         */
        protected int[][] quadraticSplit(Rectangle rectangle) {
            if (rectangle == null) {
                throw new IllegalArgumentException("Rectangle cannot be null.");
            }

            datas[usedSpace] = rectangle; // 先添加进去

            int total = usedSpace + 1; // 结点总数

            // 标记访问的条目
            int[] mask = new int[total];
            for (int i = 0; i < total; i++) {
                mask[i] = 1;
            }

            // 分裂后每个组只是有total/2个条目
            int c = total / 2 + 1;
            // 每个结点最小条目个数
            int minNodeSize = Math.round(rtree.getNodeCapacity() * rtree.getFillFactor());
            // 至少有两个
            if (minNodeSize < 2)
                minNodeSize = 2;

            // 记录没有被检查的条目的个数
            int rem = total;

            int[] group1 = new int[c];// 记录分配的条目的索引
            int[] group2 = new int[c];// 记录分配的条目的索引
            // 跟踪被插入每个组的条目的索引
            int i1 = 0, i2 = 0;

            int[] seed = pickSeeds();
            group1[i1++] = seed[0];
            group2[i2++] = seed[1];
            rem -= 2;
            mask[group1[0]] = -1;
            mask[group2[0]] = -1;

            while (rem > 0) {
                // 将剩余的所有条目全部分配到group1组中，算法终止
                if (minNodeSize - i1 == rem) {
                    for (int i = 0; i < total; i++)// 总共rem个
                    {
                        if (mask[i] != -1)// 还没有被分配
                        {
                            group1[i1++] = i;
                            mask[i] = -1;
                            rem--;
                        }
                    }
                    // 将剩余的所有条目全部分配到group1组中，算法终止
                } else if (minNodeSize - i2 == rem) {
                    for (int i = 0; i < total; i++)// 总共rem个
                    {
                        if (mask[i] != -1)// 还没有被分配
                        {
                            group2[i2++] = i;
                            mask[i] = -1;
                            rem--;
                        }
                    }
                } else {
                    // 求group1中所有条目的最小外包矩形
                    Rectangle mbr1 = (Rectangle) datas[group1[0]].clone();
                    for (int i = 1; i < i1; i++) {
                        mbr1 = mbr1.getUnionRectangle(datas[group1[i]]);
                    }
                    // 求group2中所有条目的外包矩形
                    Rectangle mbr2 = (Rectangle) datas[group2[0]].clone();
                    for (int i = 1; i < i2; i++) {
                        mbr2 = mbr2.getUnionRectangle(datas[group2[i]]);
                    }

                    // 找出下一个进行分配的条目
                    double dif = Double.NEGATIVE_INFINITY;
                    double areaDiff1 = 0, areaDiff2 = 0;
                    int sel = -1;
                    for (int i = 0; i < total; i++) {
                        if (mask[i] != -1)// 还没有被分配的条目
                        {
                            // 计算把每个条目加入每个组之后面积的增量，选择两个组面积增量差最大的条目索引
                            Rectangle a = mbr1.getUnionRectangle(datas[i]);
                            areaDiff1 = a.getArea() - mbr1.getArea();

                            Rectangle b = mbr2.getUnionRectangle(datas[i]);
                            areaDiff2 = b.getArea() - mbr2.getArea();

                            if (Math.abs(areaDiff1 - areaDiff2) > dif) {
                                dif = Math.abs(areaDiff1 - areaDiff2);
                                sel = i;
                            }
                        }
                    }

                    if (areaDiff1 < areaDiff2)// 先比较面积增量
                    {
                        group1[i1++] = sel;
                    } else if (areaDiff1 > areaDiff2) {
                        group2[i2++] = sel;
                    } else if (mbr1.getArea() < mbr2.getArea())// 再比较自身面积
                    {
                        group1[i1++] = sel;
                    } else if (mbr1.getArea() > mbr2.getArea()) {
                        group2[i2++] = sel;
                    } else if (i1 < i2)// 最后比较条目个数
                    {
                        group1[i1++] = sel;
                    } else if (i1 > i2) {
                        group2[i2++] = sel;
                    } else {
                        group1[i1++] = sel;
                    }
                    mask[sel] = -1;
                    rem--;

                }
            } // end while

            int[][] ret = new int[2][];
            ret[0] = new int[i1];
            ret[1] = new int[i2];

            for (int i = 0; i < i1; i++) {
                ret[0][i] = group1[i];
            }
            for (int i = 0; i < i2; i++) {
                ret[1][i] = group2[i];
            }
            return ret;
        }

        /**
         * 1、对每一对条目E1和E2，计算包围它们的Rectangle J，计算d = area(J) - area(E1) - area(E2);<br>
         * 2、Choose the pair with the largest d
         *
         * @return 返回两个条目如果放在一起会有最多的冗余空间的条目索引
         */
        protected int[] pickSeeds() {
            double inefficiency = Double.NEGATIVE_INFINITY;
            int i1 = 0, i2 = 0;

            // 两个for循环对任意两个条目E1和E2进行组合
            for (int i = 0; i < usedSpace; i++) {
                for (int j = i + 1; j <= usedSpace; j++)// 注意此处的j值
                {
                    Rectangle rectangle = datas[i].getUnionRectangle(datas[j]);
                    double d = rectangle.getArea() - datas[i].getArea() - datas[j].getArea();

                    if (d > inefficiency) {
                        inefficiency = d;
                        i1 = i;
                        i2 = j;
                    }
                }
            }
            return new int[] { i1, i2 }; // 返回拥有最小d的一对条目
        }

        /**
         * @return 返回包含结点中所有条目的最小Rectangle
         */
        public Rectangle getNodeRectangle() {
            if (usedSpace > 0) {
                Rectangle[] rectangles = new Rectangle[usedSpace];
                System.arraycopy(datas, 0, rectangles, 0, usedSpace);

               return null; //return Rectangle.getUnionRectangle(rectangles); // 返回包含这一系列矩形的最小矩形
            } else {
                return new Rectangle(new Point(new float[] { 0, 0 }), new Point(new float[] { 0, 0 }));
            }
        }

        /**
         * @return 是否根节点
         */
        public boolean isRoot() {
            return (parent == Constants.NULL);
        }

        /**
         * @return 是否非叶子结点
         */
        public boolean isIndex() {
            return (level != 0);
        }

        /**
         * @return 是否叶子结点
         */
        public boolean isLeaf() {
            return (level == 0);
        }

        /**
         * <b>步骤CL1：</b>初始化――记R树的根节点为N。<br>
         * <b>步骤CL2：</b>检查叶节点――如果N是个叶节点，返回N<br>
         * <b>步骤CL3：</b>选择子树――如果N不是叶节点，则从N中所有的条目中选出一个最佳的条目F，
         * 选择的标准是：如果E加入F后，F的外廓矩形FI扩张最小，则F就是最佳的条目。如果有两个
         * 条目在加入E后外廓矩形的扩张程度相等，则在这两者中选择外廓矩形较小的那个。<br>
         * <b>步骤CL4：</b>向下寻找直至达到叶节点――记Fp指向的孩子节点为N，然后返回步骤CL2循环运算， 直至查找到叶节点。
         * <p>
         *
         * @param
         * @return RTDataNode
         */
        protected abstract RTDataNode chooseLeaf(Rectangle rectangle);

        /**
         * R树的根节点为T，查找包含rectangle的叶子结点
         * <p>
         * 1、如果T不是叶子结点，则逐个查找T中的每个条目是否包围rectangle，若包围则递归调用findLeaf()<br>
         * 2、如果T是一个叶子结点，则逐个检查T中的每个条目能否匹配rectangle<br>
         *
         * @param rectangle
         * @return 返回包含rectangle的叶节点
         */
        protected abstract RTDataNode findLeaf(Rectangle rectangle);

    }
}
