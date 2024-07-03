package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.core.data.entities.Classe;
import projet.core.data.entities.Enseignement;
import projet.core.data.entities.Module;
import projet.core.data.entities.Professeur;

import java.util.List;

public interface ProfesseurService extends Service<Professeur,Long> {
    List<String> getAllGrades();
    Page<Professeur> getAllByGradeAndPortableAndPlanned(String grade, String portable,Boolean planned, Pageable pageable);
    Page<Module> getModuleByProfesseur(Professeur professeur, Pageable pageable);
    Page<Classe> getClasseByProfesseur(Professeur professeur, Pageable pageable);
    Page<Professeur> getAllByModuleAndGradeAndPortable(Module module, String grade, String portable,Pageable pageable);
    Enseignement saveEnseignement(Enseignement enseignement);
    Enseignement getByClasseAndProfesseurAndAnneeScolaireActuelle(Classe classe, Professeur professeur);
    Page<Professeur> getAllByModule(Module module,Pageable pageable);
}
