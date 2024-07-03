package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.*;
import projet.core.data.enums.EtatCours;
import projet.core.data.repositories.CoursRepository;
import projet.core.services.CoursService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursServiceImpl implements CoursService {
    private final CoursRepository coursRepository;

    @Override
    public Cours save(Cours data) {
        return coursRepository.save(data);
    }

    @Override
    public Page<Cours> getAll(Pageable pageable) {
        return coursRepository.findAllByIsArchivedFalse(pageable);
    }

    @Override
    public Optional<Cours> show(Long dataID) {
        return coursRepository.findById(dataID);
    }

    @Override
    public Page<Cours> getAllByAnnee(Pageable pageable, AnneeScolaire anneeScolaire) {
        return coursRepository.findAllByIsArchivedFalseAndAnneeScolaire(anneeScolaire,pageable);
    }

    @Override
    public Page<Cours> getAllByAnneeAndEtat(Pageable pageable, AnneeScolaire anneeScolaire, EtatCours etatCours) {
        return coursRepository.findAllByIsArchivedFalseAndAnneeScolaireAndEtat(anneeScolaire,etatCours,pageable);
    }

    @Override
    public Page<Cours> getAllByAnneeAndEtatAndSemestreAndClasseAndProf(AnneeScolaire anneeScolaire, EtatCours etat, Semestre semestre, Classe classe,Professeur prof, Pageable pageable) {
        return coursRepository.findAllByAnneeAndEtatAndSemestreAndClasseAndProf(anneeScolaire,etat,semestre,classe,prof,pageable);
    }

    @Override
    public Page<Cours> getAllByProfesseur(Professeur professeur, Pageable pageable) {
        return coursRepository.findCoursByAnneeScolaireIsActiveTrueAndProfesseur(professeur,pageable);
    }
}
