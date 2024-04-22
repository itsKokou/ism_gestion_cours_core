package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.AnneeScolaire;
import projet.core.data.repositories.AnneeScolaireRepository;
import projet.core.services.AnneeScolaireService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnneeScolaireServiceImpl implements AnneeScolaireService {
    private final AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public AnneeScolaire save(AnneeScolaire data) {
        return anneeScolaireRepository.save(data);
    }

    @Override
    public Page<AnneeScolaire> getAll(Pageable pageable) {
        return anneeScolaireRepository.findAllByIsArchivedFalse(pageable);
    }

    @Override
    public Optional<AnneeScolaire> show(Long dataID) {
        return anneeScolaireRepository.findById(dataID);
    }

    @Override
    public AnneeScolaire getAnneeActuelle() {
        return anneeScolaireRepository.findByIsActiveTrue();
    }
}

