package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.Classe;
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
    public Page<Professeur> getAllByGradeAndPortable(String grade, String portable, Pageable pageable) {
        return professeurRepository.findAllByGradeAndPortable(grade,portable,pageable);
    }

    @Override
    public Page<Module> getModuleByProfesseur(Professeur professeur, Pageable pageable) {
        return enseignementRepository.findModuleByProfesseur(professeur,pageable);
    }

    @Override
    public Page<Classe> getClasseByProfesseur(Professeur professeur, Pageable pageable) {
        return enseignementRepository.findClasseByProfesseur(professeur,pageable);
    }
}
