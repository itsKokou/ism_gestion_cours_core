package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.Classe;
import projet.core.data.entities.Enseignement;
import projet.core.data.entities.Module;
import projet.core.data.entities.Professeur;
import projet.core.data.repositories.EnseignementRepository;
import projet.core.data.repositories.ProfesseurRepository;
import projet.core.services.ProfesseurService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesseurServiceImpl implements ProfesseurService {

    private final ProfesseurRepository professeurRepository;
    private final EnseignementRepository enseignementRepository;

    @Override
    public Professeur save(Professeur data) {
        return professeurRepository.save(data);
    }

    @Override
    public Page<Professeur> getAll(Pageable pageable) {
        return professeurRepository.findAllByIsArchivedFalse(pageable);
    }

    @Override
    public Optional<Professeur> show(Long dataID) {
        return professeurRepository.findById(dataID);
    }

    @Override
    public List<String> getAllGrades() {
        return professeurRepository.findAllGrades();
    }

    @Override
    public Page<Professeur> getAllByGradeAndPortableAndPlanned(String grade, String portable,Boolean planned, Pageable pageable) {
        return professeurRepository.findAllByGradeAndPortableAndPlanned(grade,portable,planned,pageable);
    }

    @Override
    public Page<Module> getModuleByProfesseur(Professeur professeur, Pageable pageable) {
        return enseignementRepository.findModuleByProfesseur(professeur,pageable);
    }

    @Override
    public Page<Classe> getClasseByProfesseur(Professeur professeur, Pageable pageable) {
        return enseignementRepository.findClasseByProfesseur(professeur,pageable);
    }

    @Override
    public Page<Professeur> getAllByModuleAndGradeAndPortable(Module module, String grade, String portable,Pageable pageable) {
        return professeurRepository.findAllByModuleAndGradeAndPortable(module,grade,portable,pageable);
    }

    @Override
    public Enseignement saveEnseignement(Enseignement enseignement) {
        return enseignementRepository.save(enseignement);
    }

    @Override
    public Enseignement getByClasseAndProfesseurAndAnneeScolaireActuelle(Classe classe, Professeur professeur) {
        return enseignementRepository.findByClasseAndProfesseurAndAnneeScolaireIsActiveTrue(classe,professeur);
    }

    @Override
    public Page<Professeur> getAllByModule(Module module, Pageable pageable) {
        return professeurRepository.findAllByModule(module,pageable);
    }
}
