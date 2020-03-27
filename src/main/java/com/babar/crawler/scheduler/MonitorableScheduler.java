package com.babar.crawler.scheduler;

import com.babar.crawler.entity.Task;

public interface MonitorableScheduler extends Scheduler {

    public int getLeftRequestsCount(Task task);

    public int getTotalRequestsCount(Task task);

}