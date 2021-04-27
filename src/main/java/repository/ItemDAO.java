package repository;

import entity.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ItemDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Item> loadAll(Integer lendeeId) {
        return em.createNamedQuery("Item.findAll", Item.class).setParameter("lendeeId", lendeeId).getResultList();
    }

    public void persist(Item item) {
        this.em.persist(item);
    }

    public Item findOne(Integer id) {
        return em.find(Item.class, id);
    }
}
