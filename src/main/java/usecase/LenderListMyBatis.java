package usecase;

import entity.Item;
import entity.Lender;
import lombok.Getter;
import lombok.Setter;
import mybatis.dao.ItemLenderMapper;
import mybatis.dao.LenderMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

import mybatis.model.ItemLender;
import repository.*;

@Model
public class LenderListMyBatis {

    @Inject
    private LenderMapper lenderMapper;

    @Getter
    @Setter
    private ItemLender itemLender = new ItemLender();
    ;

    @Getter
    @Setter
    private Item item = new Item();

    @Inject
    private ItemDAO itemDAO;

    @Getter
    @Setter
    private List<mybatis.model.Lender> allLenders;

    @Getter
    @Setter
    private List<mybatis.model.Lender> selectedLenders;

    @Getter
    @Setter
    private mybatis.model.Lender lenderToCreate = new mybatis.model.Lender();

    @Getter
    @Setter
    private Lender lender = new Lender();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer itemID = Integer.parseInt(requestParameters.get("itemId"));
        this.item = itemDAO.findOne(itemID);
        this.loadAllClients();
        this.loadSelectedClients(itemID);
    }

    private void loadAllClients() {
        this.allLenders = lenderMapper.selectAll();
    }

    private void loadSelectedClients(Integer itemId) {
        this.selectedLenders = lenderMapper.getSelectedLenders(itemId);
    }

    @Transactional
    public String createLender() {
        lenderMapper.insert(lenderToCreate);
        return "Lenders?faces-redirect=true&itemId=" + this.item.getId();
    }
}