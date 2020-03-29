package com.edison.algorithm.pattern.command;

/**
 * @Description TODO
 * @Date 2020/3/28上午10:31
 * @Created by edsiongeng
 */
public class Invoker {

    private CommandQueue commandQueue;

    public Invoker(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    public void setCommandQueue(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    public void call(){
        commandQueue.execute();
    }
}
