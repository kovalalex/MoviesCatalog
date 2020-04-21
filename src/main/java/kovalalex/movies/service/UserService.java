package kovalalex.movies.service;

import kovalalex.movies.domain.User;
import kovalalex.movies.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@Slf4j
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> all() {
        return repository.findAll();
    }

    public Optional<User> byId(int id) {
        return repository.findById(id);
    }
}
