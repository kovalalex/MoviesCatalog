package kovalalex.movies;


import kovalalex.movies.domain.Role;
import kovalalex.movies.domain.User;
import kovalalex.movies.domain.UserGroup;
import kovalalex.movies.repository.RoleRepository;
import kovalalex.movies.repository.UserGroupRepository;
import kovalalex.movies.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashSet;

/**
 * Компонент для генерации тестовых данных
 */
@Component
@DependsOn({"dataSource"})
public class SampleDataPopulator {
    private final Logger log = LoggerFactory.getLogger(SampleDataPopulator.class);

    private final UserGroupRepository userGroupRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Autowired
    public SampleDataPopulator(UserGroupRepository userGroupRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.userGroupRepository = userGroupRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    @Transactional
    public void populateSampleData() {
        Role adminRole = new Role();
        adminRole.setTitle("Admin");
        User user1 = new User();
        user1.setEnabled(true);
        user1.setPassword("pass");
        user1.setUsername("new_user");
        user1.setRole(adminRole);
        UserGroup group = new UserGroup();
        group.setTitle("Группа1");
        group.setUsers(new HashSet<User>());
        group.getUsers().add(user1);
        userGroupRepository.save(group);




        log.info("Populated DB with sample data");
    }
}
