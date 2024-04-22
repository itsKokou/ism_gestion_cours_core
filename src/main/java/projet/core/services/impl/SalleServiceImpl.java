package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.Salle;
import projet.core.data.repositories.SalleRepository;
import projet.core.services.SalleService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalleServiceImpl implements SalleService {

    private final SalleRepository salleRepository;

    @Override
    public Salle save(Salle data) {
        return salleRepository.save(data);
    }

    @Override
    public Page<Salle> getAll(Pageable pageable) {
        return salleRepository.findAllByIsArchivedFalse(pageable);
    }

    @Override
    public Optional<Salle> show(Long dataID) {
        return salleRepository.findById(dataID);
    }
}
