package kovalalex.movies.model;

import kovalalex.movies.domain.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

/**
 * Модель пользователя отвязанная от Entity.User
 */
@ToString
@Getter
@EqualsAndHashCode(callSuper = false)
public class UserModel extends RepresentationModel<UserModel> {
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;
    private String roleTitle;
    private Integer roleId;

    public UserModel(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.getEnabled();
        this.roleTitle = user.getRole().getTitle();
        this.roleId = user.getRole().getId();
    }
}
