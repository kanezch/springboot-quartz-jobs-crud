package com.kanezheng.app.sprintbootquartzjobscrud;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@SpringBootApplication
public class SprintbootQuartzJobsCrudApplication {

	Logger logger = LoggerFactory.getLogger(SprintbootQuartzJobsCrudApplication.class);
/*	@Bean
	public SchedulerFactoryBean schedulerFactory() {
		SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();

		return factoryBean;
	}*/


	@Bean
	public Scheduler scheduler(StdSchedulerFactory sf) throws SchedulerException {
		Scheduler scheduler = sf.getScheduler();
		scheduler.start();
		logger.info("scheduler started!");
		return scheduler;
	}

	@Bean
	public StdSchedulerFactory schedulerFactory(){
		return new StdSchedulerFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(SprintbootQuartzJobsCrudApplication.class, args);
	}

}
