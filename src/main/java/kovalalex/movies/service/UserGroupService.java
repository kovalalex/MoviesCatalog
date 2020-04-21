package kovalalex.movies.service;

import kovalalex.movies.domain.User;
import kovalalex.movies.domain.UserGroup;
import kovalalex.movies.repository.UserGroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@Slf4j
public class UserGroupService {
    @Autowired
    protected UserGroupRepository repository;

    public List<UserGroup> all() {
        return repository.findAll();
    }

    public Optional<UserGroup> byId(int id) {
        return repository.findById(id);
    }

    public List<User> getUserListByGroupId(int id) {
        Optional<UserGroup> userGroup = repository.findById(id);
        return userGroup.map(group -> group.getUsers().stream()
                .collect(Collectors.toList())).orElseGet(ArrayList::new);
    }
}
