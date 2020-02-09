package com.kanezheng.app.sprintbootquartzjobscrud.service;

import com.kanezheng.app.sprintbootquartzjobscrud.dao.JobEntity;
import com.kanezheng.app.sprintbootquartzjobscrud.job.HelloWorldJob;
import com.kanezheng.app.sprintbootquartzjobscrud.repository.JobRepository;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Service
public class ScheduleJobService {

/*    @Autowired
    private SchedulerFactoryBean schedulerFactory;*/

    @Autowired
    private Scheduler scheduler;

    public int createJob(String jobNumber) {

        String jobName = "job"+jobNumber;
        String triggerName = "trigger"+jobNumber;

        JobDetail job = newJob(HelloWorldJob.class)
                .withIdentity(jobName, "group1")
                .usingJobData("jobName", jobName)
                .build();

        Trigger trigger = newTrigger()
                .withIdentity(triggerName, "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

//        Scheduler scheduler = schedulerFactory.getScheduler();

        System.out.println("#######Before scheduleJob :");
        try {
            System.out.println("Scheduler Name: " + scheduler.getSchedulerName());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
            System.out.println("Exception when shedule job");
        }

        System.out.println("scheduler.scheduleJob:" + jobName);
        return 0;
    }
}
