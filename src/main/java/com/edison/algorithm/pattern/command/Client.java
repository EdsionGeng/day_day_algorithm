package com.edison.algorithm.pattern.command;

/**
 * @Description TODO
 * @Date 2020/3/26下午11:14
 * @Created by edsiongeng
 */
public class Client {
    public static void main(String[] args) {
        FBSettingWindow fbSettingWindow = new FBSettingWindow("功能键设置");
        FunctionButton f1, f2;
        f1 = new FunctionButton("功能键1");
        f2 = new FunctionButton("功能键2");

        Command c1 = new HelpCommand();

        Command c2 = new MinmizeCommand();
        f1.setCommand(c1);
        f2.setCommand(c2);

        fbSettingWindow.addFunctionButton(f1);
        fbSettingWindow.addFunctionButton(f2);

        fbSettingWindow.display();

        f1.onClick();
        f2.onClick();
    }
}
