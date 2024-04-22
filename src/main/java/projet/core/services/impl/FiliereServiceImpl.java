package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.Filiere;
import projet.core.data.repositories.FiliereRepository;
import projet.core.services.FiliereService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FiliereServiceImpl implements FiliereService {

    private final FiliereRepository filiereRepository;

    @Override
    public Filiere save(Filiere data) {
        return filiereRepository.save(data);
    }

    @Override
    public Page<Filiere> getAll(Pageable pageable) {
        return filiereRepository.findAll(pageable);
    }

    @Override
    public Optional<Filiere> show(Long dataID) {
        return filiereRepository.findById(dataID);
    }

}
