package usecase;

import lombok.Getter;
import lombok.Setter;
import entity.Lendee;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;
import repository.*;

@ViewScoped
@Named
@Getter
@Setter
public class UpdateLendeeInfo implements Serializable {

    private Lendee lendee;

    @Inject
    private LendeeDAO lendeeDao;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer lendeeId = Integer.parseInt(requestParameters.get("lendeeId"));
        this.lendee = lendeeDao.findOne(lendeeId);
    }

    @Transactional
    public String updateLendee() {
        lendeeDao.update(this.lendee);
        return "index.xhtml?&faces-redirect=true";
    }
}
