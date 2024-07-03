package projet.core.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.core.data.entities.AnneeScolaire;
import projet.core.data.entities.Classe;
import projet.core.data.entities.Etudiant;
import projet.core.data.entities.Inscription;

import java.util.Date;
import java.util.Optional;

public interface InscriptionService extends Service<Inscription,Long> {
    Page<Inscription> getAllByAnneActiveAndClasse(Classe classe, Pageable pageable);
    Page<Inscription> getAllByAnneAndClasse(AnneeScolaire anneeScolaire, Classe classe, Pageable pageable);
    Optional<Inscription> getByAndAnneeScolaireAndEtudiant(AnneeScolaire anneeScolaire, Etudiant etudiant);
    Page<Inscription> getAllByAnneeAndClasseAndDate(AnneeScolaire anneeScolaire,Classe classe, Date date, Pageable pageable);
}
