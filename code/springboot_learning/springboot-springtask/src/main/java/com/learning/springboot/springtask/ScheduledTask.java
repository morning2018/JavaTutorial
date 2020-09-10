package com.learning.springboot.springtask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void testScheduledCron() {
        System.out.println("do testScheduledCron start");
        System.out.println("do testScheduledCron task:" + System.currentTimeMillis());
        System.out.println("do testScheduledCron end");
    }

    @Scheduled(fixedDelay = 5)
    public void testScheduledFixedDelay() {
        System.out.println("do testScheduledFixedDelay start");
        System.out.println("do testScheduledFixedDelay task:" + System.currentTimeMillis());
        System.out.println("do testScheduledFixedDelay end");
    }

}
