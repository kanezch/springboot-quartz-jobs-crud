package com.kanezheng.app.sprintbootquartzjobscrud.repository;


import com.kanezheng.app.sprintbootquartzjobscrud.dao.JobEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Service
public class JobRepositoryCustomImpl implements JobRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public JobEntity findNextWaitingJob(int status) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<JobEntity> q = cb.createQuery(JobEntity.class);

        Root<JobEntity> j = q.from(JobEntity.class);

        q.select(j).where(cb.equal(j.get("status"), 0)).orderBy(cb.desc(j.get("id")));


        TypedQuery<JobEntity> query = em.createQuery(q).setMaxResults(1);

//        List<Country> results = query.getResultList();

        JobEntity  result = query.getSingleResult();

        return result;
    }
}
