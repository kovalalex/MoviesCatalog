package kovalalex.movies.controller;

import kovalalex.movies.assembler.RoleModelAssembler;
import kovalalex.movies.model.RoleModel;
import kovalalex.movies.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {
    private RoleService service;
    private RoleModelAssembler roleAssembler;

    @Autowired
    public RoleController(RoleService service, RoleModelAssembler roleAssembler) {
        this.service = service;
        this.roleAssembler = roleAssembler;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<RoleModel>> getAll() {
        return ResponseEntity.ok(roleAssembler.toCollectionModel(service.all()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleModel> getById(@PathVariable("id") int id) {
        return service.byId(id)
                .map(roleAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public ResponseEntity<Role> addRole(@RequestBody @Validated Role role) {
//        userSystemService.saveRole(role);
//        return new ResponseEntity<>(role, HttpStatus.CREATED);
//    }
//
//    @PutMapping(value = "/{roleId}")
//    public ResponseEntity<Role> updateRole(@PathVariable("roleId") int roleId, @RequestBody @Validated Role role, BindingResult bindingResult) {
//        Role currentRole = userSystemService.findRoleById(roleId);
//        if (currentRole == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        currentRole.setTitle(role.getTitle());
//        userSystemService.saveRole(currentRole);
//        return new ResponseEntity<>(currentRole, HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/{roleId}")
//    public ResponseEntity<Void> deleteRole(@PathVariable("roleId") int roleId) {
//        Role role = userSystemService.findRoleById(roleId);
//        if (role == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        userSystemService.deleteRole(role);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//    }
}
