package com.kanezheng.app.sprintbootquartzjobscrud.service;

import com.kanezheng.app.sprintbootquartzjobscrud.job.HelloWorldJob;
import com.kanezheng.app.sprintbootquartzjobscrud.repository.JobRepository;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.TriggerKey.triggerKey;

@Service
public class ScheduleJobService {

/*    @Autowired
    private SchedulerFactoryBean schedulerFactory;*/

    @Autowired
    private Scheduler scheduler;

    @Autowired
    JobRepository jobRepository;

    public int createJob(String jobNumber) throws SchedulerException {

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
                        .withIntervalInSeconds(60)
                        .repeatForever())
                .build();

//        Scheduler scheduler = schedulerFactory.getScheduler();

        System.out.println("#######Before scheduleJob :");
        try {
            System.out.println("Scheduler Name: " + scheduler.getSchedulerName());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        scheduler.scheduleJob(job, trigger);
        System.out.println("####### Exception when schedule job #######");

        System.out.println("scheduler.scheduleJob:" + jobName);
        return 0;
    }

    public void deleteJob(Long jobId) throws SchedulerException {
        String jobName = "job"+jobId;
        scheduler.deleteJob(JobKey.jobKey(jobName, "group1"));
        System.out.println("Delete job by jobId "+ jobId);
    }

    public void updateJob(Long jobId) throws SchedulerException {

        String triggerName = "trigger" + jobId;

        Trigger trigger = newTrigger()
                .withIdentity("newTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(30).repeatForever())
                .build();

        scheduler.rescheduleJob(triggerKey(triggerName, "group1"), trigger);

        System.out.println("Reschedule job");;
    }
}
