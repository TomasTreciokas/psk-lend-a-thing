package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Item.findAll", query = "select i from Item as i where i.lendee.id=:lendeeId")
})
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    private String name;

    @ManyToOne
    @JoinColumn(name = "LENDER_ID")
    private Lendee lendee;

    @ManyToMany
    @JoinTable(name = "ITEM_LENDER")
    private List<Lender> lenders = new ArrayList<>();
}