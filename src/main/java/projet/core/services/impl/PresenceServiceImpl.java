package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.Etudiant;
import projet.core.data.entities.Presence;
import projet.core.data.entities.Seance;
import projet.core.data.repositories.PresenceRepository;
import projet.core.services.PresenceService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PresenceServiceImpl implements PresenceService {

    private final PresenceRepository presenceRepository;

    @Override
    public Presence save(Presence data) {
        return presenceRepository.save(data);
    }

    @Override
    public Page<Presence> getAll(Pageable pageable) {
        return presenceRepository.findAll(pageable);
    }

    @Override
    public Optional<Presence> show(Long dataID) {
        return presenceRepository.findById(dataID);
    }

    @Override
    public Optional<Presence> getBySeanceAndEtudiant(Seance seance, Etudiant etudiant) {
        return presenceRepository.findByIsArchivedFalseAndSeanceAndEtudiant(seance,etudiant);
    }
}
