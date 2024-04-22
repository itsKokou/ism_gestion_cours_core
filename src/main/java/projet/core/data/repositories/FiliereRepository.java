package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.core.data.entities.Filiere;

public interface FiliereRepository extends JpaRepository<Filiere,Long> {
    Page<Filiere> findAllByIsArchivedFalse(Pageable pageable);
}
