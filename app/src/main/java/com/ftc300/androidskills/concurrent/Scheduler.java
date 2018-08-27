package com.ftc300.androidskills.concurrent;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by chendong on 2018/8/24.
 * 调度器
 */

public class Scheduler {
    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
    public void test(){
        final ScheduledFuture<?> beeperHandle =   scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

            }
        }, 10, 10, SECONDS);

        scheduledThreadPoolExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                beeperHandle.cancel(true);
            }
        },60*60,SECONDS);
    }

}
