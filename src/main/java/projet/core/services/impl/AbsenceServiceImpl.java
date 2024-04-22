package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.Absence;
import projet.core.data.entities.AnneeScolaire;
import projet.core.data.entities.Etudiant;
import projet.core.data.entities.Seance;
import projet.core.data.repositories.AbsenceRepository;
import projet.core.services.AbsenceService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AbsenceServiceImpl implements AbsenceService {

    private final AbsenceRepository absenceRepository;

    @Override
    public Page<Absence> getAllByAnnee(Pageable pageable, AnneeScolaire anneeScolaire) {
        return absenceRepository.findAllByIsArchivedFalseAndSeance_Cours_AnneeScolaireOrderById(pageable, anneeScolaire);
    }

    @Override
    public Page<Absence> getAllByAnneeAndEtudiant(Pageable pageable, AnneeScolaire anneeScolaire, Etudiant etudiant) {
        return absenceRepository.findAllByIsArchivedFalseAndEtudiantAndSeance_Cours_AnneeScolaireOrderById(pageable,etudiant,anneeScolaire);
    }

    @Override
    public Optional<Absence> getAbsenceByEtudiantAndSeance(Etudiant etudiant, Seance seance) {
        return absenceRepository.findAbsenceByIsArchivedFalseAndEtudiantAndSeance(etudiant,seance);
    }

    @Override
    public Page<Absence> getByIsArchivedFalseAndSeance(Pageable pageable, Seance seance) {
        return absenceRepository.findByIsArchivedFalseAndSeance(pageable,seance);
    }

    @Override
    public Absence save(Absence data) {
        return absenceRepository.save(data);
    }

    @Override
    public Page<Absence> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Absence> show(Long dataID) {
        return absenceRepository.findById(dataID);
    }
}
