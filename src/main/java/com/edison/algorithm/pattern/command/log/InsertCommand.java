package com.edison.algorithm.pattern.command.log;

/**
 * @Description TODO
 * @Date 2020/3/28上午11:05
 * @Created by edsiongeng
 */
public class InsertCommand extends Command {

    public InsertCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        configOperator.insert(args);

    }

    @Override
    public void execute() {
        configOperator.insert(this.args);
    }
}
