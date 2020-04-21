package kovalalex.movies.assembler;

import kovalalex.movies.controller.RoleController;
import kovalalex.movies.controller.UserController;
import kovalalex.movies.domain.User;
import kovalalex.movies.model.UserModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User, UserModel> {
    public UserModelAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(User entity) {
        UserModel model = new UserModel(entity);
        model.add(linkTo(methodOn(UserController.class).getById(entity.getId())).withSelfRel());
        model.add(linkTo(methodOn(RoleController.class).getById(entity.getRole().getId())).withRel("role"));
        return model;
    }
}
