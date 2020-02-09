package com.kanezheng.app.sprintbootquartzjobscrud.job;

import com.kanezheng.app.sprintbootquartzjobscrud.dao.JobEntity;
import com.kanezheng.app.sprintbootquartzjobscrud.repository.JobRepository;
import com.kanezheng.app.sprintbootquartzjobscrud.service.ScheduleJobService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldJob implements Job {

   Logger logger = LoggerFactory.getLogger(HelloWorldJob.class);

    @Autowired
    private JobRepository jobRepository;

    public HelloWorldJob(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void execute(JobExecutionContext context) {

        Scheduler scheduler = context.getScheduler();

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String jobName = dataMap.getString("jobName");
        try {
            System.out.println("Hello this is : "+ jobName + " running in scheduler: "+ scheduler.getSchedulerName());

            JobEntity jobEntity = JobEntity.builder().name(jobName).build();
            JobEntity jobEntityResp = jobRepository.save(jobEntity);
            logger.info("Save jobEntity to database: {} ", jobEntityResp);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}