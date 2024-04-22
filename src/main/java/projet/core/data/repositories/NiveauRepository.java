package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.core.data.entities.Niveau;

public interface NiveauRepository extends JpaRepository<Niveau,Long> {
    Page<Niveau> findAllByIsArchivedFalse(Pageable pageable);
}
