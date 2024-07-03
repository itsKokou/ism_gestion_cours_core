package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.core.data.entities.Absence;
import projet.core.data.entities.AnneeScolaire;
import projet.core.data.entities.Etudiant;
import projet.core.data.entities.Seance;

import java.util.List;
import java.util.Optional;

public interface AbsenceRepository extends JpaRepository<Absence,Long> {
    Page<Absence> findAllByIsArchivedFalse(Pageable pageable);
    Page<Absence> findAllByIsArchivedFalseAndSeance_Cours_AnneeScolaireOrderById(Pageable pageable, AnneeScolaire anneeScolaire);
    Page<Absence> findAllByIsArchivedFalseAndEtudiantAndSeance_Cours_AnneeScolaireOrderById(Pageable pageable,Etudiant etudiant,AnneeScolaire anneeScolaire);
    Optional<Absence> findAbsenceByIsArchivedFalseAndEtudiantAndSeance(Etudiant etudiant, Seance seance);
    Page<Absence> findByIsArchivedFalseAndSeance(Pageable pageable, Seance seance);
}
