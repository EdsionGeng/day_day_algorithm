package com.edison.algorithm.core.jmx;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * @Description TODO
 * @Date 2020/3/14下午4:35
 * @Created by edsiongeng
 */
public class Jack extends NotificationBroadcasterSupport implements JackMBean {
    private int seq = 0;


    @Override
    public void hi() {
        Notification notification = new Notification("jack,hi", this, ++seq, System.currentTimeMillis(), "jack");
        sendNotification(notification);
    }
}
