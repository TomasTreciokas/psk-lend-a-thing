package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Lendee.findAll", query = "select l from Lendee as l")
})
@Getter
@Setter
public class Lendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    @OneToMany(mappedBy = "lendee")
    private List<Item> items = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lendee lendee = (Lendee) o;
        return Objects.equals(email, lendee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

