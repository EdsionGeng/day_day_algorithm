package com.edison.algorithm.leetcode;

//最大以1为边界正方形
public class LeetCode1139 {

    public int largest1BorderSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxEdge = Math.min(m, n);
        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int edge = ans + 1; edge <= maxEdge; edge++) {
                    if (i + edge - 1 >= m || j + edge - 1 >= n) {
                        break;
                    }
                    int left = colSum[i + edge][j] - colSum[i][j];
                    int top = rowSum[i][j + edge] - rowSum[i][j];
                    if (left != edge || top != left) {
                        break;
                    }
                    int right = colSum[i + edge][j + edge - 1] - colSum[i][j + edge - 1];
                    int bottom = rowSum[i + edge - 1][j + edge] - rowSum[i + edge - 1][j];
                    if (right == edge && bottom == edge) {
                        ans = edge;
                    }
                }
            }

        }
        return ans * ans;

    }
}
