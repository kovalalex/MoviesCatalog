package kovalalex.movies.repository;

import kovalalex.movies.domain.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {
}
