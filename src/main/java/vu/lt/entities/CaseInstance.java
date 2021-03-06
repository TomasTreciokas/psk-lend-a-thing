package vu.lt.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "CASE_INSTANCE")
@NamedQueries({
        @NamedQuery(name = "CaseInstance.findAll", query = "select c from CaseInstance as c")
})
public class CaseInstance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long lenderId;
    private Long lendeeId;
    private Long itemId;
    private String fromTs;
    private String toTs;
    private BigDecimal depositValue;

    public CaseInstance(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLenderId() {
        return lenderId;
    }

    public void setLenderId(Long lenderId) {
        this.lenderId = lenderId;
    }

    public Long getLendeeId() {
        return lendeeId;
    }

    public void setLendeeId(Long lendeeId) {
        this.lendeeId = lendeeId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getFromTs() {
        return fromTs;
    }

    public void setFromTs(String fromTs) {
        this.fromTs = fromTs;
    }

    public String getToTs() {
        return toTs;
    }

    public void setToTs(String toTs) {
        this.toTs = toTs;
    }

    public BigDecimal getDepositValue() {
        return depositValue;
    }

    public void setDepositValue(BigDecimal depositValue) {
        this.depositValue = depositValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseInstance accountAuthorization = (CaseInstance) o;
        return Objects.equals(id, accountAuthorization.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
