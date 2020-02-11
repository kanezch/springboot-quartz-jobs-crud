package com.kanezheng.app.sprintbootquartzjobscrud.repository;

import com.kanezheng.app.sprintbootquartzjobscrud.dao.JobEntity;


public interface JobRepositoryCustom {

    JobEntity findNextWaitingJob(int status);
}
