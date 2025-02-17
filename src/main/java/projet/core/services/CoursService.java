package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import projet.core.data.entities.*;
import projet.core.data.enums.EtatCours;

public interface CoursService extends Service<Cours,Long> {
    Page<Cours> getAllByAnnee(Pageable pageable, AnneeScolaire anneeScolaire);
    Page<Cours> getAllByAnneeAndEtat(Pageable pageable, AnneeScolaire anneeScolaire, EtatCours etatCours);
    Page<Cours> getAllByAnneeAndEtatAndSemestreAndClasseAndProf( AnneeScolaire anneeScolaire, EtatCours etat,Semestre semestre,Classe classe,Professeur prof, Pageable pageable);
    Page<Cours> getAllByProfesseur(Professeur professeur,Pageable pageable);
}
