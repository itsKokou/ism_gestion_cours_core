package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.core.data.entities.Classe;
import projet.core.data.entities.Module;
import projet.core.data.entities.Professeur;

import java.util.List;

public interface ProfesseurService extends Service<Professeur,Long> {
    List<String> getAllGrades();
    Page<Professeur> getAllByGradeAndPortable(String grade, String portable, Pageable pageable);
    Page<Module> getModuleByProfesseur(Professeur professeur, Pageable pageable);
    Page<Classe> getClasseByProfesseur(Professeur professeur, Pageable pageable);
}
