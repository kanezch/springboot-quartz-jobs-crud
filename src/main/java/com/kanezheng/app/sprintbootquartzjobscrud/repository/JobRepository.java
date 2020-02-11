package com.kanezheng.app.sprintbootquartzjobscrud.repository;

import com.kanezheng.app.sprintbootquartzjobscrud.dao.JobEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends CrudRepository<JobEntity, Long>, JobRepositoryCustom{

}