package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.Niveau;
import projet.core.data.repositories.NiveauRepository;
import projet.core.services.NiveauService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NiveauServiceImpl implements NiveauService {

    private final NiveauRepository niveauRepository;

    @Override
    public Niveau save(Niveau data) {
        return niveauRepository.save(data);
    }

    @Override
    public Page<Niveau> getAll(Pageable pageable) {
        return niveauRepository.findAllByIsArchivedFalse(pageable);
    }

    @Override
    public Optional<Niveau> show(Long dataID) {
        return niveauRepository.findById(dataID);
    }

}
