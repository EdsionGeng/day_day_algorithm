package com.edison.algorithm.pattern.command.undo;

/**
 * @Description TODO
 * @Date 2020/3/28上午10:40
 * @Created by edsiongeng
 */
public abstract class AbstractCommand {

    public abstract int execute(int value);

    public abstract int undo();
}
