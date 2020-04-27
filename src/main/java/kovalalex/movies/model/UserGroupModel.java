package kovalalex.movies.model;

import kovalalex.movies.domain.UserGroup;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

/**
 * Модель групп пользователя отвязанная от Entity
 */
@ToString
@Getter
@EqualsAndHashCode(callSuper = false)
public class UserGroupModel extends RepresentationModel<UserGroupModel> {
    private final Integer id;
    private final String title;

    public UserGroupModel(UserGroup userGroup) {
        super();
        this.id = userGroup.getId();
        this.title = userGroup.getTitle();
    }
}
