package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.core.data.entities.AnneeScolaire;

public interface AnneeScolaireRepository extends JpaRepository<AnneeScolaire,Long> {
    Page<AnneeScolaire> findAllByIsArchivedFalse(Pageable pageable);
    AnneeScolaire findByIsActiveTrue();
}
