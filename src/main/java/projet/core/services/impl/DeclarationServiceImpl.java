package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.Declaration;
import projet.core.data.enums.EtatDeclaration;
import projet.core.data.repositories.DeclarationRepository;
import projet.core.services.DeclarationService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeclarationServiceImpl implements DeclarationService {

    private final DeclarationRepository declarationRepository;

    @Override
    public Declaration save(Declaration data) {
        return declarationRepository.save(data);
    }

    @Override
    public Page<Declaration> getAll(Pageable pageable) {
        return declarationRepository.findAll(pageable);
    }

    @Override
    public Optional<Declaration> show(Long dataID) {
        return declarationRepository.findById(dataID);
    }

    @Override
    public Page<Declaration> getEtudiantDeclarationsByEtat(EtatDeclaration etat, Pageable pageable) {
        return declarationRepository.findEtudiantDeclarationsByEtat(etat,pageable);
    }
}
