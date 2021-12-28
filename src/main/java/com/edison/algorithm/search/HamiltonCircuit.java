package com.edison.algorithm.search;

/**
 * 描述:
 * 哈密顿回路、
 *
 * @author gengyc
 * @create 2021-12-22 15:56
 */
public class HamiltonCircuit {

    public void getHamiltonCircuit(int[][] adjMatrix) {
        boolean[] used = new boolean[adjMatrix.length];
        int[] path = new int[adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            used[i] = false;
            path[i] = -1;
        }
        used[0] = true;
        path[0] = 0;
        dfs(adjMatrix, path, used, 1);
    }

    public boolean dfs(int[][] adjMartix, int[] path, boolean[] used, int step) {
        if (step == adjMartix.length) {
            if (adjMartix[path[step - 1]][0] == 1) {
                for (int i = 0; i < path.length; i++){
                    System.out.print(((char) (path[i] + 'a')) + "——>");}
                System.out.print(((char) (path[0] + 'a')));
                System.out.println();
                return true;
            }
            return false;
        } else {
            for (int i = 0; i < adjMartix.length; i++) {
                if (!used[i] && adjMartix[path[step - 1]][i] == 1) {
                    used[i] = true;
                    path[step] = i;
                    if (dfs(adjMartix, path, used, step + 1)) {
                        return true;
                    } else {
                        used[i] = false;
                        path[step] = -1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HamiltonCircuit test = new HamiltonCircuit();
        int[][] adjMatrix = {{-1,1,1,1,-1,-1},
                {1,-1,1,-1,-1,1},
                {1,1,-1,1,1,-1},
                {1,-1,1,-1,1,-1},
                {-1,-1,1,1,-1,1},
                {-1,1,-1,-1,1,-1}};
        System.out.println(adjMatrix[-1]);
        test.getHamiltonCircuit(adjMatrix);
    }

}