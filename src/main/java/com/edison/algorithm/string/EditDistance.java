package com.edison.algorithm.string;

/**
 * 描述:
 * 莱文斯坦编辑距离
 *
 * @author gengyc
 * @create 2021-12-02 10:12
 */
public class EditDistance {

    public static int minDistance(String source, String target) {
        int sourceLen = source.length();
        int targetLen = target.length();
        if (sourceLen == 0) {
            return targetLen;
        }
        if (targetLen == 0) {
            return sourceLen;
        }
        int arr[][] = new int[sourceLen + 1][targetLen + 1];
        for (int i = 0; i < sourceLen + 1; i++) {
            arr[i][0] = i;
        }
        for (int i = 0; i < targetLen + 1; i++) {
            arr[0][i] = i;
        }
        Character sourceStr, targetStr;
        for (int i = 1; i < sourceLen + 1; i++) {
            sourceStr = source.charAt(i - 1);
            for (int j = 1; j < targetLen + 1; j++) {
                targetStr = target.charAt(j - 1);
                if (sourceStr.equals(targetStr)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    arr[i][j] = (Math.min(Math.min(arr[i][j - 1], arr[i - 1][j]), arr[i - 1][j - 1])) + 1;
                }
            }
        }
        System.out.println("----------矩阵打印---------------");
        //矩阵打印
        for(int i=0;i<sourceLen+1;i++){

            for(int j=0;j<targetLen+1;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("----------矩阵打印---------------");
        return arr[sourceLen][targetLen];
    }

    public static double getsimilarity(String str1, String str2) {
        double distance = minDistance(str1, str2);
        double maxlen = Math.max(str1.length(), str2.length());
        double res = (maxlen - distance) / maxlen;

        return res;
    }

    public static String evaluate(String str1, String str2) {
        double result = getsimilarity(str1, str2);
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String str1 = "maxin";
        String str2 = "maxn";
        int result = minDistance(str1, str2);
        // String res = evaluate(str1,str2);
        System.out.println("最小编辑距离minDistance:" + result);
        //  System.out.println(str1+"与"+str2+"相似度为："+res);


    }
}