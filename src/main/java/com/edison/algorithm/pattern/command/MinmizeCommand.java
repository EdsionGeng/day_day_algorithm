package com.edison.algorithm.pattern.command;

/**
 * @Description TODO
 * @Date 2020/3/26下午11:12
 * @Created by edsiongeng
 */
public class MinmizeCommand extends Command {
    private WindowHandler windowHandler;

    public MinmizeCommand() {
        this.windowHandler = new WindowHandler();
    }

    @Override
    public void execute() {
        windowHandler.minmize();

    }
}
