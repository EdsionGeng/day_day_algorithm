package com.edison.algorithm.pattern.expression;

/**
 * @Description TODO
 * @Date 2020/3/29下午4:13
 * @Created by edsiongeng
 */
public class Client {

    public static void main(String[] args) {
        String instruction = "up move 5 and down run 10 and left move 5";
        InstructionHandler handler = new InstructionHandler();
        handler.handle(instruction);
        String outString = handler.output();
        System.out.println(outString);
    }
}
