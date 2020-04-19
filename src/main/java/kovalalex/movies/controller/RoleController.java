package kovalalex.movies.controller;

import kovalalex.movies.domain.Role;
import kovalalex.movies.service.UserSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {
    private UserSystemService userSystemService;

    @Autowired
    public RoleController(UserSystemService userSystemService) {
        this.userSystemService = userSystemService;
    }

    @GetMapping
    public Collection<Role> test() {
        return userSystemService.findAllRoles();
    }

    @PostMapping
    public ResponseEntity<Role> addRole(@RequestBody @Validated Role role) {
        userSystemService.saveRole(role);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{roleId}")
    public ResponseEntity<Role> updateRole(@PathVariable("roleId") int roleId, @RequestBody @Validated Role role, BindingResult bindingResult) {
        Role currentRole = userSystemService.findRoleById(roleId);
        if (currentRole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentRole.setTitle(role.getTitle());
        userSystemService.saveRole(currentRole);
        return new ResponseEntity<>(currentRole, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable("roleId") int roleId) {
        Role role = userSystemService.findRoleById(roleId);
        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userSystemService.deleteRole(role);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
