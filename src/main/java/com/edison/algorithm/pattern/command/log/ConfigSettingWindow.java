package com.edison.algorithm.pattern.command.log;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Date 2020/3/28上午11:17
 * @Created by edsiongeng
 */
public class ConfigSettingWindow {

    private ArrayList<Command> commands = new ArrayList<>();
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call(String args) {
        command.execute(args);
        commands.add(command);
    }

    public void save() {
        FileUtil.writeCommands(commands);
    }

    public void recover() {
        ArrayList list = FileUtil.readCommands();

        for (Object obj : list) {
            ((Command) obj).execute();
        }
    }
}
