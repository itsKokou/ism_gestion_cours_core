package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.Semestre;
import projet.core.data.repositories.SemestreRepository;
import projet.core.services.SemestreService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SemestreServiceImpl implements SemestreService {
    private final SemestreRepository semestreRepository;

    @Override
    public Semestre save(Semestre data) {
        return semestreRepository.save(data);
    }

    @Override
    public Page<Semestre> getAll(Pageable pageable) {
        return semestreRepository.findAllByIsArchivedFalse(pageable);
    }

    @Override
    public Optional<Semestre> show(Long dataID) {
        return semestreRepository.findById(dataID);
    }
}
