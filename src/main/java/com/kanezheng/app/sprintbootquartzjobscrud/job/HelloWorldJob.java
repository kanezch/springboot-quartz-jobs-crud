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

    @Override
    public void execute(JobExecutionContext context) {

        Scheduler scheduler = context.getScheduler();

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String jobName = dataMap.getString("jobName");
        try {
            System.out.println("Hello this is : "+ jobName + " running in scheduler: "+ scheduler.getSchedulerName());

//            JobEntity jobEntity = JobEntity.builder().name(jobName).status(0).build();
//            JobEntity jobEntityResp = jobRepository.save(jobEntity);
//            logger.info("Save jobEntity to database: {} ", jobEntityResp);

            JobEntity nextWaitingJob = jobRepository.findNextWaitingJob(0);
            logger.info("####jobQuery from database: {} ", nextWaitingJob);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}