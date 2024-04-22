package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.Module;
import projet.core.data.repositories.ModuleRepository;
import projet.core.services.ModuleService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;

    @Override
    public Module save(Module data) {
        return moduleRepository.save(data);
    }

    @Override
    public Page<Module> getAll(Pageable pageable) {
        return moduleRepository.findAllByIsArchivedFalse(pageable);
    }

    @Override
    public Optional<Module> show(Long dataID) {
        return moduleRepository.findById(dataID);
    }
}
