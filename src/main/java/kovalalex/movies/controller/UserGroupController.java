package kovalalex.movies.controller;

import kovalalex.movies.domain.User;
import kovalalex.movies.domain.UserGroup;
import kovalalex.movies.service.UserSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(value = "/usergroups")
public class UserGroupController {
    private final UserSystemService userSystemService;

    @Autowired
    public UserGroupController(UserSystemService userSystemService) {
        this.userSystemService = userSystemService;
    }

    @GetMapping
    public Collection<UserGroup> getAll() {
        return userSystemService.findAllUserGroups();
    }

    @PostMapping
    public ResponseEntity<UserGroup> addUser(@RequestBody @Valid UserGroup userGroup) throws Exception {
        userSystemService.saveUserGroup(userGroup);
        return new ResponseEntity<>(userGroup, HttpStatus.CREATED);
    }
}
