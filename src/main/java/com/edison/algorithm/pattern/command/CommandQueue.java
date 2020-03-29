package com.edison.algorithm.pattern.command;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Date 2020/3/28上午10:27
 * @Created by edsiongeng
 */
public class CommandQueue {

    private ArrayList<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void execute() {
        for (Object command : commands) {
            ((Command) command).execute();
        }
    }
}
