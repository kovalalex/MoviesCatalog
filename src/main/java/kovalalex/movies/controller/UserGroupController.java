package kovalalex.movies.controller;

import kovalalex.movies.assembler.UserGroupModelAssembler;
import kovalalex.movies.assembler.UserModelAssembler;
import kovalalex.movies.model.UserGroupModel;
import kovalalex.movies.model.UserModel;
import kovalalex.movies.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usergroups")
public class UserGroupController {

    private final UserGroupService service;
    private final UserGroupModelAssembler groupAssembler;
    private final UserModelAssembler userAssembler;

    @Autowired
    public UserGroupController(UserGroupService service, UserGroupModelAssembler groupAssembler,
                               UserModelAssembler userAssembler) {
        this.service = service;
        this.groupAssembler = groupAssembler;
        this.userAssembler = userAssembler;
    }


    @GetMapping
    public ResponseEntity<CollectionModel<UserGroupModel>> getAll() {
        return ResponseEntity.ok(groupAssembler.toCollectionModel(service.all()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserGroupModel> getById(@PathVariable("id") int id) {
        return service.byId(id)
                .map(groupAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/{id}/userList")
    public ResponseEntity<CollectionModel<UserModel>> getUserListByGroupId(@PathVariable("id") int id) {
        return ResponseEntity.ok(userAssembler.toCollectionModel(service.getUserListByGroupId(id)));
    }


}
