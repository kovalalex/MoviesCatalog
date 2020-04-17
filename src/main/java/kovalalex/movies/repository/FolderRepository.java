package kovalalex.movies.repository;

import kovalalex.movies.domain.Folder;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FolderRepository extends JpaRepository<Folder, Integer> {
}
