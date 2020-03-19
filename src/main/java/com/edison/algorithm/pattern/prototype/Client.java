package com.edison.algorithm.pattern.prototype;

/**
 * @Description TODO
 * @Date 2020/3/12下午10:52
 * @Created by edsiongeng
 */
public class Client {
    public static void main(String[] args) throws Exception{
        WeeklyLog log_previous, log_new;
        log_previous = new WeeklyLog();
        Attachment attachment = new Attachment();
        log_previous.setAttachment(attachment);
        log_new = log_previous.deepClone();
        System.out.println(log_previous==log_new);
        System.out.println(log_previous.getAttachment()==log_new.getAttachment());
    }
}
