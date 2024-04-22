package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.core.data.entities.AnneeScolaire;
import projet.core.data.entities.Cours;
import projet.core.data.enums.EtatCours;

public interface CoursService extends Service<Cours,Long> {
    Page<Cours> getAllByAnnee(Pageable pageable, AnneeScolaire anneeScolaire);
    Page<Cours> getAllByAnneeAndEtat(Pageable pageable, AnneeScolaire anneeScolaire, EtatCours etatCours);
}
