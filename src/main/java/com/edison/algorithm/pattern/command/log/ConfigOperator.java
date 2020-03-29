package com.edison.algorithm.pattern.command.log;

import java.io.Serializable;

/**
 * @Description TODO
 * @Date 2020/3/28上午11:06
 * @Created by edsiongeng
 */
public class ConfigOperator implements Serializable {
    public void insert(String args) {
        System.out.println("Insert node：" + args);
    }

    public void modify(String args) {
        System.out.println("Update node:" + args);
    }

    public void delete(String args) {
        System.out.println("Delete node:" + args);
    }
}
