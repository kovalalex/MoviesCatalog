package kovalalex.movies.service;

import kovalalex.movies.domain.UserGroup;
import kovalalex.movies.repository.UserGroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class UserGroupService {
    @Autowired
    protected UserGroupRepository repository;
    public List<UserGroup> all(){
        return repository.findAll();
    }
}
