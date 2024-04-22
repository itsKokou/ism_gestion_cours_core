package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.core.data.entities.Etudiant;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Optional<Etudiant> findEtudiantByMatricule(String matricule);
    Page<Etudiant> findAllByIsArchivedFalse(Pageable pageable);

}
