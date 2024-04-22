package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.core.data.entities.Classe;
import projet.core.data.entities.Inscription;
import projet.core.data.entities.Seance;

import java.util.List;

public interface SeanceService extends Service<Seance,Long> {
    List<Seance> getAllByClasse(Classe classe);
    Page<Inscription> getLesEtudiantsBySeance(Seance seance, Pageable pageable);

}
