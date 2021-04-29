package rest.model.response;

import entity.Item;
import entity.Lendee;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class LendeeResponse {

    private Integer id;
    private String email;

    public LendeeResponse(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public static LendeeResponse from(Lendee lendee){
        return new LendeeResponse(lendee.getId(), lendee.getEmail());
    }
}
