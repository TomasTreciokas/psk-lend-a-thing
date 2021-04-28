package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
}

