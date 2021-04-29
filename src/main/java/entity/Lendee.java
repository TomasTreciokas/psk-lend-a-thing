package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public Lendee(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public Lendee(){
    }
}

