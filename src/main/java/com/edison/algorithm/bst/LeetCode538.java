package com.edison.algorithm.bst;


import com.edison.algorithm.struct.TreeNode;

//Convert BST to Greater Tree
public class LeetCode538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;

    }
    //morris遍历的实现原则
    //记作当前节点为cur。
    //如果cur无左孩子，cur向右移动（cur=cur.right）
    //如果cur有左孩子，找到cur左子树上最右的节点，记为mostright
    //如果mostright的right指针指向空，让其指向cur，cur向左移动（cur=cur.left）
    //如果mostright的right指针指向cur，让其指向空，cur向右移动（cur=cur.right）
    //实现以上的原则，即实现了morris遍历。
    //morris遍历的实质
    //建立一种机制，对于没有左子树的节点只到达一次，对于有左子树的节点会到达两次

    public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }
        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }
}
