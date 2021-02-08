package com.edison.algorithm.core.asm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 描述:
 *
 * @author gengyongchang
 * @create 2021-02-08 10:23
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        ClassReader classReader = new ClassReader("com/edison/algorithm/core/asm/Base");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();

        File file = new File("C:\\Users\\gengyongchang\\IdeaProjects\\day_day_algorithm\\target\\classes\\com\\edison\\algorithm\\core\\asm\\Base.class");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(data);
        fileOutputStream.close();
        System.out.println("new generator cc success!!!");
    }
}