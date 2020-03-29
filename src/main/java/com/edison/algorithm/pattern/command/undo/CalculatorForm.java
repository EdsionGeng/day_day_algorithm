package com.edison.algorithm.pattern.command.undo;

/**
 * @Description TODO
 * @Date 2020/3/28上午10:42
 * @Created by edsiongeng
 */
public class CalculatorForm {

    private AbstractCommand command;

    public void setCommand(AbstractCommand command) {
        this.command = command;
    }

    public void compute(int value) {
        int i = command.execute(value);
        System.out.println("Execute result:" + i);
    }

    public void undo() {
        int i = command.undo();
        System.out.println("Undo execute result:"+i);
    }
}
