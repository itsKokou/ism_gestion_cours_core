package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.core.data.entities.Module;

public interface ModuleRepository extends JpaRepository<Module,Long> {
    Page<Module> findAllByIsArchivedFalse(Pageable pageable);
}
