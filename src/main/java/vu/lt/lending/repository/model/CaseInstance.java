package vu.lt.lending.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

//TODO: to be determined implementation
@Entity
public class CaseInstance {

    @Size(max = 50)
    private String caseInstanceId;

    public CaseInstance(String caseInstanceId) {
        this.caseInstanceId = caseInstanceId;
    }

    //Needed for database saving
    public CaseInstance(){}

    public String getCaseInstanceId() {
        return caseInstanceId;
    }

    public void setCaseInstanceId(String caseInstanceId) {
        this.caseInstanceId = caseInstanceId;
    }
}
