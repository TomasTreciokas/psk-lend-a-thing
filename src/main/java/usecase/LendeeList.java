package usecase;

import lombok.Getter;
import lombok.Setter;
import entity.Lendee;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import repository.*;

@Model
public class LendeeList {

    @Inject
    private LendeeDAO lendeeDAO;

    @Getter
    @Setter
    private Lendee lendee = new Lendee();

    @Getter
    private List<Lendee> lendeeList;

    @PostConstruct
    public void init(){
        this.lendeeList = lendeeDAO.loadAll();
    }

    @Transactional
    public String createLendee() {
        this.lendeeDAO.persist(lendee);
        return "index?faces-redirect=true";
    }
}
