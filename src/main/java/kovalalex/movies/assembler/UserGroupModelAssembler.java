package kovalalex.movies.assembler;

import kovalalex.movies.domain.UserGroup;
import kovalalex.movies.model.UserGroupModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserGroupModelAssembler extends RepresentationModelAssemblerSupport<UserGroup, UserGroupModel> {
    public UserGroupModelAssembler(Class<?> controllerClass, Class<UserGroupModel> resourceType) {
        super(controllerClass, resourceType);
    }

    @Override
    public UserGroupModel toModel(UserGroup entity) {

        UserGroupModel model = new UserGroupModel(entity);

        //model.add(linkTo());

        return null;
    }
}
