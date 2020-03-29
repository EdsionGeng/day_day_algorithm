package com.edison.algorithm.pattern.command.log;

import com.sun.org.apache.xpath.internal.operations.Mod;

/**
 * @Description TODO
 * @Date 2020/3/28上午11:15
 * @Created by edsiongeng
 */
public class ModifyCommand extends Command {

    public ModifyCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args = args;

    }

    @Override
    public void execute() {
        configOperator.modify(this.args);

    }
}
