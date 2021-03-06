package vu.lt.entities;

import javax.annotation.ManagedBean;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
        @NamedQuery(name = "AccountAuthorization.findAll", query = "select a from AccountAuthorization as a")
})
public class AccountAuthorization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    private String name;

    //manyToOne CustomerID

    public AccountAuthorization() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountAuthorization accountAuthorization = (AccountAuthorization) o;
        return Objects.equals(id, accountAuthorization.id) &&
                Objects.equals(name, accountAuthorization.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
