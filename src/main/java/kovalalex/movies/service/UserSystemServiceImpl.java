package kovalalex.movies.service;

import kovalalex.movies.domain.Role;
import kovalalex.movies.domain.User;
import kovalalex.movies.domain.UserGroup;
import kovalalex.movies.repository.RoleRepository;
import kovalalex.movies.repository.UserGroupRepository;
import kovalalex.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Реализация сервиса для операций с пользователями, ролями и группами пользователей
 */
@Service
public class UserSystemServiceImpl implements UserSystemService {
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private UserGroupRepository userGroupRepository;

    @Autowired
    public UserSystemServiceImpl(RoleRepository roleRepository, UserRepository userRepository, UserGroupRepository userGroupRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public Collection<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleById(int id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (roleOptional.isPresent()) {
            return roleOptional.get();
        }
        return null;
    }

    @Override
    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Collection<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Collection<UserGroup> findAllUserGroups() {
        return userGroupRepository.findAll();
    }

    @Override
    public UserGroup findUserGroupById(int id) {
        Optional<UserGroup> userGroupOptional = userGroupRepository.findById(id);
        if (userGroupOptional.isPresent())
            return userGroupOptional.get();
        return null;
    }

    @Override
    public void deleteUserGroup(UserGroup userGroup) {
        userGroupRepository.delete(userGroup);
    }

    @Override
    public void saveUserGroup(UserGroup userGroup) {
        userGroupRepository.save(userGroup);
    }
}
