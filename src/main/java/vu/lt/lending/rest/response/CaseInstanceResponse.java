package vu.lt.lending.rest.response;

import javax.json.bind.annotation.JsonbCreator;

public class CaseInstanceResponse {

    private final String caseId;

    @JsonbCreator
    public CaseInstanceResponse(String caseId) {
        this.caseId = caseId;
    }

    public static CaseInstanceResponse from(String caseId) {
        return new CaseInstanceResponse(caseId);
    }

    public String getCaseId() {
        return caseId;
    }
}
