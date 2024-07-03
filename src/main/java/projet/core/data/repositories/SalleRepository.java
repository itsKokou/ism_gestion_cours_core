package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.core.data.entities.Salle;

public interface SalleRepository extends JpaRepository<Salle,Long> {
    Page<Salle> findAllByIsArchivedFalseAndIsPlanned(Pageable pageable,boolean isPlanned);
    Page<Salle> findAllByIsArchivedFalse(Pageable pageable);
}
