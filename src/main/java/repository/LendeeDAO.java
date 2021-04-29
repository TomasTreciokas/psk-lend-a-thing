package repository;

import entity.Lendee;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LendeeDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Lendee> loadAll() {
        return em.createNamedQuery("Lendee.findAll", Lendee.class).getResultList();
    }

    public void persist(Lendee lendee) {
        this.em.persist(lendee);
    }

    @Transactional
    public Lendee findOne(Integer id) {
        return em.find(Lendee.class, id);
    }

    public Lendee update(Lendee lendee) {
        return em.merge(lendee);
    }
}