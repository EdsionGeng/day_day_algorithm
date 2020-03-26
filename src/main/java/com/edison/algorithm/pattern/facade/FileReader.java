package com.edison.algorithm.pattern.facade;

import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;

/**
 * @Description TODO
 * @Date 2020/3/21上午8:43
 * @Created by edsiongeng
 */
public class FileReader {

    public String Read(String fileNameSrc) {
        System.out.println("read file to get word:");

        InputStream file = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            file = new FileInputStream(fileNameSrc);
            int data;
            while ((data = file.read()) != -1) {
                stringBuilder.append((char) data);
            }
        } catch (Exception e) {

        }
        return stringBuilder.toString();
    }
}