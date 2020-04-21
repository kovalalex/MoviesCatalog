package kovalalex.movies.controller;

import kovalalex.movies.assembler.UserGroupModelAssembler;
import kovalalex.movies.domain.User;
import kovalalex.movies.domain.UserGroup;
import kovalalex.movies.model.UserGroupModel;
import kovalalex.movies.service.UserGroupService;
import kovalalex.movies.service.UserSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usergroups")
public class UserGroupController {
    private final UserGroupService service;
    private final UserGroupModelAssembler assembler;

    @Autowired
    public UserGroupController(UserGroupService service, UserGroupModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }


    @GetMapping
    public ResponseEntity<CollectionModel<UserGroupModel>> getAll() {
        return ResponseEntity.ok(assembler.toModelAll(service.all()));
    }


}
