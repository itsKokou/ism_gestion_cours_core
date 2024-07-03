package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.AnneeScolaire;
import projet.core.data.entities.Classe;
import projet.core.data.entities.Etudiant;
import projet.core.data.entities.Inscription;
import projet.core.data.repositories.InscriptionRepository;
import projet.core.services.InscriptionService;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;

    @Override
    public Inscription save(Inscription data) {
        return inscriptionRepository.save(data);
    }

    @Override
    public Page<Inscription> getAll(Pageable pageable) {
        return inscriptionRepository.findAll(pageable);
    }

    @Override
    public Optional<Inscription> show(Long dataID) {
        return inscriptionRepository.findById(dataID);
    }

    @Override
    public Page<Inscription> getAllByAnneActiveAndClasse(Classe classe, Pageable pageable) {
        return inscriptionRepository.findAllByAnneeActiveAndClasse(classe,pageable);
    }

    @Override
    public Page<Inscription> getAllByAnneAndClasse(AnneeScolaire anneeScolaire, Classe classe, Pageable pageable) {
        return inscriptionRepository.findAllByAnneeAndClasse(anneeScolaire,classe,pageable);
    }

    @Override
    public Optional<Inscription> getByAndAnneeScolaireAndEtudiant(AnneeScolaire anneeScolaire, Etudiant etudiant) {
        return inscriptionRepository.findByIsArchivedFalseAndAnneeScolaireAndEtudiant(anneeScolaire,etudiant);
    }

    @Override
    public Page<Inscription> getAllByAnneeAndClasseAndDate(AnneeScolaire anneeScolaire, Classe classe, Date date, Pageable pageable) {
        return inscriptionRepository.findAllByAnneeAndClasseAndDate(anneeScolaire, classe, date, pageable);
    }

}
