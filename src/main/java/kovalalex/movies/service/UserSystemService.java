package kovalalex.movies.service;

import kovalalex.movies.domain.Role;
import kovalalex.movies.domain.User;
import kovalalex.movies.domain.UserGroup;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface UserSystemService {
    Collection<Role> findAllRoles();
    Role findRoleById(int id);
    void deleteRole(Role role);
    void saveRole(Role role);
    
    Collection<User>findAllUsers();
    User findUserById(int id);
    void deleteUser(User user);
    void saveUser(User user);
    
    Collection<UserGroup>findAllUserGroups();
    UserGroup findUserGroupById(int id);
    void deleteUserGroup(UserGroup userGroup);
    void saveUserGroup(UserGroup userGroup);

}
