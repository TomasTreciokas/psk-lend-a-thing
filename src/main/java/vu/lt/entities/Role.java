package vu.lt.entities;

import vu.lt.general.RoleType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROLE")
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "select r from Role as r")
})
public class Role {

    @Id
    private Integer id;

    private Long systemUserId;

    @Enumerated
    private RoleType type;

    public Role(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(Long systemUserId) {
        this.systemUserId = systemUserId;
    }

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
