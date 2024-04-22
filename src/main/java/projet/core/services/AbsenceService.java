package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.core.data.entities.Absence;
import projet.core.data.entities.AnneeScolaire;
import projet.core.data.entities.Etudiant;
import projet.core.data.entities.Seance;

import java.util.Optional;

public interface AbsenceService extends Service<Absence,Long> {
    Page<Absence> getAllByAnnee(Pageable pageable, AnneeScolaire anneeScolaire);
    Page<Absence> getAllByAnneeAndEtudiant(Pageable pageable, AnneeScolaire anneeScolaire, Etudiant etudiant);
    Optional<Absence> getAbsenceByEtudiantAndSeance(Etudiant etudiant, Seance seance);
    Page<Absence> getByIsArchivedFalseAndSeance(Pageable pageable, Seance seance);
}
