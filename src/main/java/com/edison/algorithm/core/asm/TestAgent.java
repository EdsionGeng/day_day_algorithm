package com.edison.algorithm.core.asm;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * 描述:
 *
 * @author gengyongchang
 * @create 2021-02-08 14:10
 */
public class TestAgent {
    public static void agentmain(String args, Instrumentation instrumentation) {
        instrumentation.addTransformer(new TestTransformer(), true);
        try {
            instrumentation.retransformClasses(Base.class);
            System.out.println("Agent load done.");
        } catch (UnmodifiableClassException e) {
            System.out.println("agent load failed!");
            e.printStackTrace();
        }
    }

}