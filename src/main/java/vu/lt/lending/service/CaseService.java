package vu.lt.lending.service;

import vu.lt.lending.repository.CaseInstanceRepository;
import vu.lt.lending.repository.model.CaseInstance;
import vu.lt.lending.rest.request.CaseInstanceRequest;
import vu.lt.lending.rest.response.CaseInstanceResponse;

import javax.inject.Inject;

public class CaseService {

    @Inject
    private CaseInstanceRepository repository;

    public CaseInstanceResponse retrieveCaseInstance(String caseId) {
        CaseInstance caseInstanceFromDb = repository.findCaseInstanceById(caseId);

        return CaseInstanceResponse.from(caseInstanceFromDb.getCaseInstanceId());
    }

    public CaseInstanceResponse createCase(CaseInstanceRequest request) {
        repository.save(new CaseInstance(request.getCaseId()));

        return CaseInstanceResponse.from(request.getCaseId());
    }
}
