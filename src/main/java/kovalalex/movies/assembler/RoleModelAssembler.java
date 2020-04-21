package kovalalex.movies.assembler;

import kovalalex.movies.controller.RoleController;
import kovalalex.movies.domain.Role;
import kovalalex.movies.model.RoleModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RoleModelAssembler extends RepresentationModelAssemblerSupport<Role, RoleModel> {
    public RoleModelAssembler() {
        super(RoleController.class, RoleModel.class);
    }

    @Override
    public RoleModel toModel(Role entity) {
        RoleModel model = new RoleModel(entity);
        model.add(linkTo(methodOn(RoleController.class).getById(entity.getId())).withSelfRel());
        return model;
    }
}
