package com.edison.algorithm.core.asm;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * 描述:
 *
 * @author gengyongchang
 * @create 2021-02-08 13:39
 */
public class JavassistTest {
    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com/edison/algorithm/core/asm/Base");
        CtMethod method = cc.getDeclaredMethod("process");
        method.insertBefore("\"{ System.out.println(\\\"start\\\"); }\"");
        method.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("");
        Base h = (Base) c.newInstance();
        h.process();
    }
}