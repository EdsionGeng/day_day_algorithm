package com.edison.algorithm.leetcode;

//图像渲染
public class LeetCode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origincolor = image[sr][sc];
        fill(image, sr, sc, origincolor, color);
        return image;
    }

    public void fill(int[][] image, int x, int y, int originColor, int newColor) {
        if (!inArea(image, x, y)) return;
        if (image[x][y] != originColor) return;
        if (image[x][y] == -1) return;
        image[x][y] = -1;
        fill(image, x + 1, y, originColor, newColor);
        fill(image, x, y + 1, originColor, newColor);
        fill(image, x - 1, y, originColor, newColor);
        fill(image, x, y - 1, originColor, newColor);
        image[x][y] = newColor;
    }


    public boolean inArea(int[][] image, int x, int y) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        LeetCode733 le = new LeetCode733();
        image=le.floodFill(image, sr, sc, 2);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j <image[0].length ; j++) {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}
