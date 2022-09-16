package com.edison.algorithm.offer;

//矩阵中的路径 m*n二维字符网格 和一个字符单词word 存在返回true。否则返回false
public class Offer12 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }

        int m = board.length, n = board[0].length;
        char[] chs = word.toCharArray();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == chs[0])
                    if (dfs(board, i, j, visited, chs, 0)) return true;

            }
        }
        return false;

    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] visited, char[] chs, int index) {
        if (index == chs.length) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j] || board[i][j] != chs[index]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(board, i + 1, j, visited, chs, index + 1)
                || dfs(board, i - 1, j, visited, chs, index + 1)
                || dfs(board, i, j + 1, visited, chs, index + 1)
                || dfs(board, i, j - 1, visited, chs, index + 1);
        visited[i][j] = false;
        return res;
    }
}
