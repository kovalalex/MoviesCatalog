package kovalalex.movies.assembler;

import kovalalex.movies.domain.UserGroup;
import kovalalex.movies.model.UserGroupModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public CollectionModel<UserGroupModel> toModelAll(List<UserGroup> userGroupList) {
        List<UserGroupModel> collect = userGroupList.stream().map(this::toModel).collect(Collectors.toList());
        List<Link> links = new ArrayList<>();
        CollectionModel<UserGroupModel> collectionModel = new CollectionModel<>(collect, links);
        return collectionModel;
    }
}
