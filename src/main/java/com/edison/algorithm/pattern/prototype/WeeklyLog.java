package com.edison.algorithm.pattern.prototype;

import java.io.*;

/**
 * @Description TODO
 * @Date 2020/3/12下午10:46
 * @Created by edsiongeng
 */
public class WeeklyLog implements Serializable {
    private Attachment attachment;
    private String name;
    private String date;
    private String content;

    public Attachment getAttachment() {
        return (this.attachment);
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WeeklyLog clone() {
        try {
            Object obj = null;
            obj = super.clone();
            return (WeeklyLog) obj;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("unsupported clone");
            return null;
        }

    }

    public WeeklyLog deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bap = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bap);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bap.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLog) ois.readObject();
    }
}
