package com.kanezheng.app.sprintbootquartzjobscrud.repository;

import com.kanezheng.app.sprintbootquartzjobscrud.dao.JobEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface JobRepositoryCustom {

    JobEntity findNextWaitingJob(int status);
}
