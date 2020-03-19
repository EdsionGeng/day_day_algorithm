package com.edison.algorithm.core.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @Description TODO
 * @Date 2020/3/14下午4:39
 * @Created by edsiongeng
 */
public class HiAgent {



    public static void main(String[] args) throws Exception {

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName hiName = new ObjectName("yunge:name=Hello");
        Hi hi = new Hi();
        server.registerMBean(hi, hiName);
        Jack jack = new Jack();
        server.registerMBean(jack, new ObjectName("jack :name=Jack"));
        jack.addNotificationListener(new HiListener(),null,hi);
        Thread.sleep(50000);
    }
}
