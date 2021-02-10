package vu.lt.lending.rest.request;

import javax.json.bind.annotation.JsonbCreator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CaseInstanceRequest {

    @NotEmpty(message = "Case_id cannot be empty")
    @Pattern(regexp = "/^[0-9]+$/", message = "Not valid case_id format")
    private final String caseId;

    @JsonbCreator
    public CaseInstanceRequest(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseId() {
        return caseId;
    }
}
