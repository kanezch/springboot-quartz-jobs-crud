package com.kanezheng.app.sprintbootquartzjobscrud.controller;


import com.kanezheng.app.sprintbootquartzjobscrud.service.ScheduleJobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScheduleJobController {

    @Autowired
    private ScheduleJobService scheduleJobService;

    public ScheduleJobController(ScheduleJobService scheduleJobService) {
        this.scheduleJobService = scheduleJobService;
    }

    @GetMapping(path = "/job/{number}")
    public ResponseEntity createJob(@PathVariable String number) throws SchedulerException {

        scheduleJobService.createJob(number);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(path = "/job/{jobId}")
    public ResponseEntity deleteJob(@PathVariable Long jobId) throws SchedulerException {

        scheduleJobService.deleteJob(jobId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/job/{jobId}")
    public ResponseEntity updateJob(@PathVariable Long jobId) throws SchedulerException {

        scheduleJobService.updateJob(jobId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
