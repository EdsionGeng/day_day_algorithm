package com.edison.algorithm.pattern.command.undo;

/**
 * @Description TODO
 * @Date 2020/3/28上午10:40
 * @Created by edsiongeng
 */
public class ConcreteCommand extends AbstractCommand {
    private Adder adder = new Adder();
    private int value;

    @Override
    public int execute(int value) {
        this.value=value;
        return adder.add(value);
    }

    @Override
    public int undo() {
        return adder.add(-value);
    }
}
