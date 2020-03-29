package com.edison.algorithm.pattern.command.undo;

/**
 * @Description TODO
 * @Date 2020/3/28上午10:45
 * @Created by edsiongeng
 */
public class Client {
    public static void main(String[] args) {
        CalculatorForm form = new CalculatorForm();
        AbstractCommand command;
        command = new ConcreteCommand();
        form.setCommand(command);

        form.compute(10);
        form.compute(5);
        form.compute(10);

        form.undo();

    }
}
