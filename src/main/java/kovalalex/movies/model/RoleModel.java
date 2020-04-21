package kovalalex.movies.model;

import kovalalex.movies.domain.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@ToString
@Getter
@EqualsAndHashCode
public class RoleModel extends RepresentationModel<RoleModel> {
    private final Integer id;
    private final String title;

    public RoleModel(Role role) {
        this.id = role.getId();
        this.title = role.getTitle();
    }
}
