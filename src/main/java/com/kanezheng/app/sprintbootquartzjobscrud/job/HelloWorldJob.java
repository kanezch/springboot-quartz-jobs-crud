package com.kanezheng.app.sprintbootquartzjobscrud.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

public class HelloWorldJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String jobName = dataMap.getString("jobName");
        System.out.println("Hello: "+ jobName);
    }
}