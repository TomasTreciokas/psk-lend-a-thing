package vu.lt.lending.repository;

import vu.lt.lending.repository.model.CaseInstance;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class CaseInstanceRepository {

    @Inject
    private EntityManager entityManager;

    public void save(CaseInstance caseInstance){
        entityManager.persist(caseInstance);
    }

    public CaseInstance findCaseInstanceById(String id){
        return entityManager.find(CaseInstance.class, id);
    }

    public CaseInstance updateCase(CaseInstance caseInstance){
        return entityManager.merge(caseInstance);
    }
}
