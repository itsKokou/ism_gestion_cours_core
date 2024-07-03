package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import projet.core.data.entities.*;
import projet.core.data.entities.Module;

public interface ClasseService extends Service<Classe,Long> {
    Page<Classe> getAllByNiveauAndFiliereAndPlanned(Pageable pageable, Niveau niveau, Filiere filiere,Boolean planned);
    Page<Classe> getByProfesseurAndModuleAndSemestre(Professeur professeur, Module module, Semestre semestre, Pageable pageable);
}
