package com.edison.algorithm.algorithm;

import java.util.Arrays;

/**
 * @Description TODO
 * @Date 2022/6/21下午3:56
 * @Created by edsiongeng
 */
public class BWT {
    public String encode(String line) {
        String str = line;
        int len = str.length();
        char[] charArray = str.toCharArray();
        char[][] ch = new char[len][len];
        for (int i = 0; i < len; i++) {
            char[] c_tmp = charArray.clone();
            for (int j = 0; j < len; j++) {
                ch[i][j] = c_tmp[j];
                if (j <= len - 2) {
                    charArray[j + 1] = c_tmp[j];
                }
                charArray[0] = c_tmp[len - 1];
            }

        }
        String[] strings = new String[len];
        for (int i = 0; i < len; i++) {
            StringBuffer chline = new StringBuffer();
            for (char c : ch[i]) {
                chline.append(c);
            }
            strings[i] = chline.toString();
        }
        Arrays.sort(strings);
        StringBuffer sBuffer = new StringBuffer();
        for (String s : strings) {
            sBuffer.append(s.substring(len - 1, len));
        }
        return sBuffer.toString();
    }

    public String decode(String source) {
        int len=source.length();
        String result="";
        StringBuffer []matrix=new StringBuffer[len];
        StringBuffer tmp=new StringBuffer(source);
        String []tmp1=new String[len];

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i>0){
                    tmp=matrix[j];
                    matrix[j]=new StringBuffer();
                    matrix[j].append(source.charAt(j));
                    matrix[j].append(tmp);

                }
                else {
                    matrix[j]=new StringBuffer();
                    matrix[j].append(source.charAt(j));
                }

            }
            for(int k=0;k<matrix.length;k++)
                tmp1[k]=matrix[k].toString();

            Arrays.sort(tmp1);

            for(int k=0;k<matrix.length;k++){
                matrix[k].delete(0, len-1);
                matrix[k]=new StringBuffer(tmp1[k]);
            }

        }
        for(StringBuffer st:matrix)
            if(st.charAt(len-1)=="|".charAt(0))
                result=st.toString();

        return result;
    }

    public static void main(String[] args) {
        BWT bwt=new BWT();
        //System.out.println(bwt.encode("banana"));
      System.out.println(bwt.decode("nnbaaa"));

    }
}
