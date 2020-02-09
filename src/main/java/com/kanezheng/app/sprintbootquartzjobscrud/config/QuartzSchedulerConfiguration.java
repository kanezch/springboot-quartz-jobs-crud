package com.kanezheng.app.sprintbootquartzjobscrud.config;

import javax.sql.DataSource;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class QuartzSchedulerConfiguration {

    @Autowired
    ApplicationContext applicationContext;

/*    @Bean
    public SchedulerFactoryBean scheduler() {

        SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();

//        quartzScheduler.setConfigLocation(new ClassPathResource("quartz.properties"));


        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        quartzScheduler.setJobFactory(jobFactory);

        return quartzScheduler;
    }*/
    @Bean
    public Scheduler quartzScheduler() throws SchedulerException {

        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();

        schedulerFactory.setConfigLocation(new ClassPathResource("quartz.properties"));

        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        schedulerFactory.setJobFactory(jobFactory);

        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        System.out.println("#######scheduler start!!!@###$$$");
        return scheduler;
    }
}
