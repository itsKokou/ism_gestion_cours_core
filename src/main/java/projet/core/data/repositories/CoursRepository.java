package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.core.data.entities.AnneeScolaire;
import projet.core.data.entities.Cours;
import projet.core.data.enums.EtatCours;

public interface CoursRepository extends JpaRepository<Cours,Long> {
    Page<Cours> findAllByIsArchivedFalse(Pageable pageable);
    Page<Cours> findAllByIsArchivedFalseAndAnneeScolaire(AnneeScolaire anneeScolaire, Pageable pageable);
    Page<Cours> findAllByIsArchivedFalseAndAnneeScolaireAndEtat(AnneeScolaire anneeScolaire, EtatCours etatCours, Pageable pageable);
}
