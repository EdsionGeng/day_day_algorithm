package com.edison.algorithm.core.asm;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 描述:
 *
 * @author gengyongchang
 * @create 2021-02-08 13:51
 */
public class TestTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("Transforming" + className);
        try {
            ClassPool cp = ClassPool.getDefault();
            CtClass cc = cp.get("com/edison/algorithm/core/asm/Base");
            CtMethod method = cc.getDeclaredMethod("process");
            method.insertBefore("\"{ System.out.println(\\\"start\\\"); }\"");
            method.insertAfter("{ System.out.println(\"end\"); }");
            return cc.toBytecode();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}