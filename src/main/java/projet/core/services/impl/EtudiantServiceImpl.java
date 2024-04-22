package projet.core.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.core.data.entities.Etudiant;
import projet.core.data.repositories.EtudiantRepository;
import projet.core.services.EtudiantService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Override
    public Etudiant save(Etudiant data) {
        return etudiantRepository.save(data);
    }

    @Override
    public Page<Etudiant> getAll(Pageable pageable) {
        return etudiantRepository.findAllByIsArchivedFalse(pageable);
    }

    @Override
    public Optional<Etudiant> show(Long dataID) {
        return etudiantRepository.findById(dataID);
    }

    @Override
    public Optional<Etudiant> getEtudiantByMatricule(String matricule) {
        return etudiantRepository.findEtudiantByMatricule(matricule);
    }
}
