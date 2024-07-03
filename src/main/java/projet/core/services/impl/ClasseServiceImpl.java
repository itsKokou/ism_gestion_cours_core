package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.*;
import projet.core.data.entities.Module;
import projet.core.data.repositories.ClasseRepository;
import projet.core.services.ClasseService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClasseServiceImpl implements ClasseService {
    private final ClasseRepository classeRepository;

    @Override
    public Classe save(Classe data) {
        return classeRepository.save(data);
    }

    @Override
    public Page<Classe> getAll(Pageable pageable) {
        return classeRepository.findAllByIsArchivedFalseAndIsPlannedTrue(pageable);
    }

    @Override
    public Optional<Classe> show(Long dataID) {
        return classeRepository.findById(dataID);
    }

    @Override
    public Page<Classe> getAllByNiveauAndFiliereAndPlanned(Pageable pageable, Niveau niveau, Filiere filiere,Boolean planned) {
        return classeRepository.findByNiveauAndFiliereAndPlanned(niveau, filiere,planned,pageable);
    }

    @Override
    public Page<Classe> getByProfesseurAndModuleAndSemestre(Professeur professeur, Module module, Semestre semestre, Pageable pageable) {
        return classeRepository.findByProfesseurAndModuleAndSemestreNiveau(professeur, module, semestre.getNiveau(),pageable);
    }

}
