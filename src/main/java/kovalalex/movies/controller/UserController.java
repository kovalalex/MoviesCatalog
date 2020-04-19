package kovalalex.movies.controller;

import kovalalex.movies.domain.User;
import kovalalex.movies.service.UserSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserSystemService userSystemService;

    @Autowired
    public UserController(UserSystemService userSystemService) {
        this.userSystemService = userSystemService;
    }

    @GetMapping
    public Collection<User> getAll() {
        return userSystemService.findAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody @Valid User user) throws Exception {
        userSystemService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
