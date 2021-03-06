package vu.lt.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SYSTEM_USER")
@NamedQueries({
        @NamedQuery(name = "SystemUser.findAll", query = "select r from SystemUser as r")
})
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //id
    //role
    //borrowed items
    //items borrowed to other people
    //contact information

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemUser systemUser = (SystemUser) o;
        return Objects.equals(id, systemUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}