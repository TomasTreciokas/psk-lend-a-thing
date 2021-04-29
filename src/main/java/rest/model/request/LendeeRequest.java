package rest.model.request;

import entity.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LendeeRequest {

    private int id;
    private String email;
    private List<Item> items;
}
