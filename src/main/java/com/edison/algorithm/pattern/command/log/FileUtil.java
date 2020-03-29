package com.edison.algorithm.pattern.command.log;

import java.io.*;
import java.util.ArrayList;

/**
 * @Description TODO
 * @Date 2020/3/28上午11:21
 * @Created by edsiongeng
 */
public class FileUtil {

    public static void writeCommands(ArrayList commands) {

        try {
            FileOutputStream file = new FileOutputStream("confg.log");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(file));
            objectOutputStream.writeObject(commands);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList readCommands() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/edsiongeng/IdeaProjects/day_day_algorithm/confg.log");
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));

            ArrayList commands = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();
            return commands;
        } catch (Exception e){
        return null;
    }
}

}
