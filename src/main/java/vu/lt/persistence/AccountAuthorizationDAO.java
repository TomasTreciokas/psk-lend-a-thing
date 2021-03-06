package vu.lt.persistence;

import vu.lt.entities.AccountAuthorization;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@ApplicationScoped
public class AccountAuthorizationDAO {

    @PersistenceContext
    private EntityManager em;

    public List<AccountAuthorization> loadAll() {
        return em.createNamedQuery("AccountAuthorization.findAll", AccountAuthorization.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(AccountAuthorization accountAuthorization){
        this.em.persist(accountAuthorization);
    }
}
