package com.edison.algorithm.bst;

import com.edison.algorithm.struct.TreeNode;

public class LeetCode889 {

    int[] pre, post;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.pre = preorder;
        this.post = postorder;

        return make(0, 0, pre.length);
    }

    public TreeNode make(int i0, int i1, int N) {
        if (N == 0) return null;
        TreeNode root = new TreeNode(pre[i0]);
        if (N == 1) return root;

        int L = 1;
        for (; L < N; L++) {
            if (post[i1 + L - 1] == pre[i0 + 1])
                break;
        }

        root.left = make(i0 + 1, i1, L);
        root.right = make(i0 + L + 1, i1 + L, N - 1 - L);
        return root;

    }

}
