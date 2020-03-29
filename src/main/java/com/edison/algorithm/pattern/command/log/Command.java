package com.edison.algorithm.pattern.command.log;

import java.io.Serializable;

/**
 * @Description TODO
 * @Date 2020/3/28上午11:01
 * @Created by edsiongeng
 */
public abstract class Command implements Serializable {

    protected String name;
    protected String args;
    protected ConfigOperator configOperator;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfigOperator(ConfigOperator configOperator) {
        this.configOperator = configOperator;

    }

    public abstract void execute(String args);

    public abstract void execute();

}
