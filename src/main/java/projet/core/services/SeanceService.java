package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.core.data.entities.*;

import java.util.List;

public interface SeanceService extends Service<Seance,Long> {
    Page<Inscription> getLesEtudiantsBySeance(Seance seance, Pageable pageable);
    List<Seance> getAllByClasse(Classe classe);
    List<Seance> getAllByClasseAndProfesseur(Classe classe, Professeur professeur);
    List<Seance> getAllBySalle(Salle salle);
}
