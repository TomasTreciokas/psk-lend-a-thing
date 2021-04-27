package usecase;

import lombok.Getter;
import lombok.Setter;
import entity.*;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import repository.*;

@Model
public class ItemsList {

    @Inject
    private LendeeDAO lendeeDAO;

    @Inject
    private ItemDAO itemDAO;

    @Getter
    @Setter
    private Item item = new Item();

    @Getter
    @Setter
    private Lendee lendee = new Lendee();

    @Getter
    private List<Item> itemList;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer lenderId = Integer.parseInt(requestParameters.get("lendeeId"));
        this.lendee = lendeeDAO.findOne(lenderId);
        this.itemList = itemDAO.loadAll(lenderId);
    }

    @Transactional
    public String createItem() {
        item.setLendee(this.lendee);
        itemDAO.persist(item);
        return "Items?faces-redirect=true&lendeeId=" + this.lendee.getId();
    }
}
