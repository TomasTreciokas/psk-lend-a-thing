package vu.lt.usecases;

import vu.lt.entities.AccountAuthorization;
import vu.lt.persistence.AccountAuthorizationDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class AccountAuthorizations implements Serializable {

    @Inject
    private AccountAuthorizationDAO accountAuthorizationDAO;

    private AccountAuthorization accountAuthorizationToCreate = new AccountAuthorization();
    private List<AccountAuthorization> allAuthorizations;

    @PostConstruct
    public void init(){
        loadAccountAuthorizations();
    }

    public void loadAccountAuthorizations() {
        this.allAuthorizations = accountAuthorizationDAO.loadAll();
    }

    public List<AccountAuthorization> getAllAccountAuthorizations(){
        return allAuthorizations;
    }

    @Transactional
    public String createAccountAuthorization(){
        this.accountAuthorizationDAO.persist(accountAuthorizationToCreate);
        return "SUCCESS";
    }

    public AccountAuthorization getAccountAuthorizationToCreate() {
        return accountAuthorizationToCreate;
    }

    public void setAccountAuthorizationToCreate(AccountAuthorization accountAuthorizationToCreate) {
        this.accountAuthorizationToCreate = accountAuthorizationToCreate;
    }
}
