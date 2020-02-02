package com.kanezheng.app.sprintbootquartzjobscrud.service;

import com.kanezheng.app.sprintbootquartzjobscrud.SprintbootQuartzJobsCrudApplication;
import com.kanezheng.app.sprintbootquartzjobscrud.job.HelloWorldJob;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Service
public class ScheduleJobService {

    Logger logger = LoggerFactory.getLogger(ScheduleJobService.class);

    @Autowired
    private final Scheduler scheduler;

    public ScheduleJobService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public int createJob(String jobNumber) throws SchedulerException {

        String jobName = "job"+jobNumber;
        String triggerName = "trigger"+jobNumber;

        JobDataMap jobDataMap = new JobDataMap();


        JobDetail job = newJob(HelloWorldJob.class)
                .withIdentity(jobName, "group1")
                .usingJobData("jobName", jobName)
                .build();

        Trigger trigger = newTrigger()
                .withIdentity(triggerName, "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();


        scheduler.scheduleJob(job, trigger);

        logger.info("scheduler.scheduleJob");

        return 0;
    }
}
