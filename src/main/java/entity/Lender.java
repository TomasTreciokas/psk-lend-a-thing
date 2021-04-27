package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Lender.findAll", query = "select l from Lender as l")
})
@Getter
@Setter
public class Lender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String email;

    @ManyToMany(mappedBy = "lenders")
    private List<Item> items = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lender lender = (Lender) o;
        return Objects.equals(surname, lender.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname);
    }
}

