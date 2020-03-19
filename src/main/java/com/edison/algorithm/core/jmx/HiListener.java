package com.edison.algorithm.core.jmx;

import javax.management.Notification;
import javax.management.NotificationListener;

/**
 * @Description TODO
 * @Date 2020/3/14下午4:38
 * @Created by edsiongeng
 */
public class HiListener implements NotificationListener {
    @Override
    public void handleNotification(Notification notification, Object handback) {
        if (handback instanceof Hi) {
            Hi hi = (Hi) handback;
            hi.printHello(notification.getMessage());
        }

    }
}
