package com.edison.algorithm.pattern.prototype;

import java.io.Serializable;

/**
 * @Description TODO
 * @Date 2020/3/12下午10:48
 * @Created by edsiongeng
 */
public class Attachment  implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void download() {
        System.out.println("download atatchment:" + name);
    }
}
