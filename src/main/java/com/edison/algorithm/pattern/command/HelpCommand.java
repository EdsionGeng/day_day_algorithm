package com.edison.algorithm.pattern.command;

/**
 * @Description TODO
 * @Date 2020/3/26下午11:07
 * @Created by edsiongeng
 */
public class HelpCommand extends Command {
    private HelpHandler helpHandler;

    public HelpCommand() {
        helpHandler = new HelpHandler();
    }

    @Override
    public void execute() {
        helpHandler.display();

    }
}
