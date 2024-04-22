package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.core.data.entities.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre,Long> {
    Page<Semestre> findAllByIsArchivedFalse(Pageable pageable);
}
