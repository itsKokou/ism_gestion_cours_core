package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.Classe;
import projet.core.data.entities.Inscription;
import projet.core.data.entities.Seance;
import projet.core.data.repositories.SeanceRepository;
import projet.core.services.SeanceService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository seanceRepository;

    @Override
    public Seance save(Seance data) {
        return seanceRepository.save(data);
    }

    @Override
    public Page<Seance> getAll(Pageable pageable) {
        return seanceRepository.findAllByIsArchivedFalse(pageable);
    }

    @Override
    public Optional<Seance> show(Long dataID) {
        return seanceRepository.findById(dataID);
    }


    @Override
    public List<Seance> getAllByClasse(Classe classe) {
        return seanceRepository.findAllByClasse(classe);
    }

    @Override
    public Page<Inscription> getLesEtudiantsBySeance(Seance seance,  Pageable pageable) {
        return seanceRepository.findLesEtudiantsBySeance(seance,pageable);
    }
}
