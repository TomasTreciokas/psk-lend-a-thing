package repository;

import mybatis.model.Lender;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class LenderDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Lender> loadAll() {
        return em.createNamedQuery("Lender.findAll", Lender.class).getResultList();
    }

    public void persist(Lender lender) {
        this.em.persist(lender);
    }

    public void remove(Lender lender) {
        this.em.remove(lender);
    }

    public Lender findOne(Integer id) {
        return em.find(Lender.class, id);
    }
}
