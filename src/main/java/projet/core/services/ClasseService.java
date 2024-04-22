package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.core.data.entities.Classe;
import projet.core.data.entities.Filiere;
import projet.core.data.entities.Niveau;

public interface ClasseService extends Service<Classe,Long> {
    Page<Classe> getAllByNiveauAndFiliere(Pageable pageable, Niveau niveau, Filiere filiere);
}
