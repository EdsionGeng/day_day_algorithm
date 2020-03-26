package com.edison.algorithm.pattern.facade;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Description TODO
 * @Date 2020/3/21上午8:55
 * @Created by edsiongeng
 */
public class FileWriter {
    public void write(String encryptStr, String fileNameDesc) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileNameDesc);
            byte[] str = encryptStr.getBytes();
            outputStream.write(str, 0, str.length);
            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }

    }
}
