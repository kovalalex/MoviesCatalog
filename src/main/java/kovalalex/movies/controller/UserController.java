package kovalalex.movies.controller;

import kovalalex.movies.assembler.UserModelAssembler;
import kovalalex.movies.model.UserModel;
import kovalalex.movies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService service;
    private final UserModelAssembler userAssembler;

    @Autowired
    public UserController(UserService service, UserModelAssembler userAssembler) {
        this.service = service;
        this.userAssembler = userAssembler;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<UserModel>> getAll() {
        return ResponseEntity.ok(userAssembler.toCollectionModel(service.all()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserModel> getById(@PathVariable("id") int id) {
        return service.byId(id)
                .map(userAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
