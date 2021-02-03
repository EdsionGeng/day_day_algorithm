package com.edison.algorithm.algorithm;

/**
 * @Description 颜色填充算法
 * @Date 2020/9/1下午10:43
 * @Created by edsiongeng
 */
public class FloodFill {


    int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        fill(image, sr, sc, originColor, newColor);
        return image;
    }


    void fill(int[][] image, int x, int y, int originColor, int newColor) {
        if (!inArea(image, x, y)) return;
        if (image[x][y] != originColor) return;
        if (image[x][y] == -1) return;
        image[x][y] = -1;

        fill(image, x, y + 1, originColor, newColor);
        fill(image, x, y - 1, originColor, newColor);
        fill(image, x + 1, y, originColor, newColor);
        fill(image, x - 1, y, originColor, newColor);
        image[x][y] = newColor;
    }

    boolean inArea(int[][] image, int x, int y) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }
}
