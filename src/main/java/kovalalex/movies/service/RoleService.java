package kovalalex.movies.service;

import kovalalex.movies.domain.Role;
import kovalalex.movies.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@Slf4j
public class RoleService {

    @Autowired
    RoleRepository repository;

    public List<Role> all() {
        return repository.findAll();
    }

    public Optional<Role> byId(int id) {
        return repository.findById(id);
    }

}
