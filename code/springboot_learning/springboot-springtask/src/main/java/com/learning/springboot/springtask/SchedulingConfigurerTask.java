package com.learning.springboot.springtask;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * SchedulingConfigurer实现的定时任务：
 * 1. CronTrigger
 * 1.1 固定cron
 * 1.2 动态cron-配置文件
 * 1.3 动态cron-数据库
 * 1.4 Trigger与Task执行逻辑
 *  1.4.1 Trigger先触发cron
 *  1.4.2 等待第一次约定时间开始执行
 *  1.4.3 执行结束后，再次触发循环1.4.1和1.4.2
 *  1.4.4 在task执行过程中，如果有cron匹配，也不会执行新的task
 2. PeriodicTrigger
 * 2.1 固定间隔时间
 * 2.2 动态间隔时间-配置文件
 * 2.3 动态间隔时间-数据库
 *
 *  SchedulingConfigurer task
 * @author weiyt
 * @date 2020/9/8 22:06
 * @since 0.0.1-SNAPSHOT
 */
@Component
public class SchedulingConfigurerTask implements SchedulingConfigurer {

    private final static String CRON = "0/5 * * * * ?";

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(doTask(), getTrigger());
    }

    private Runnable doTask() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("do task：" + System.currentTimeMillis());
                try {
                    //任务处理10秒
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private Trigger getTrigger() {
        return new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                System.out.println("trigger: " + System.currentTimeMillis());
                // todo:按照cron表达式触发
                CronTrigger trigger = new CronTrigger(CRON);

                //todo: 间隔时间触发
                //PeriodicTrigger trigger = new PeriodicTrigger(5000);
                return trigger.nextExecutionTime(triggerContext);
            }
        };
    }

}
