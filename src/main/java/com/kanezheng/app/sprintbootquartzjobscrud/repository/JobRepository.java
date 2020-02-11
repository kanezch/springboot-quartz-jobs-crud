package com.kanezheng.app.sprintbootquartzjobscrud.repository;

import com.kanezheng.app.sprintbootquartzjobscrud.dao.JobEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends CrudRepository<JobEntity, Long>, JobRepositoryCustom{

/*    @Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
    User findByLastnameOrFirstname(@Param("lastname") String lastname,
                                   @Param("firstname") String firstname);*/

/*    @Query("select j from JobEntity j where j.name = :jobname")
    JobEntity findNextJob(@Param("jobname") String jobname);*/

/*    @Query("select j from JobEntity j where j.status = :status order by j.id  1")
    JobEntity findNextWaitingJob(@Param("status") int status);*/
}