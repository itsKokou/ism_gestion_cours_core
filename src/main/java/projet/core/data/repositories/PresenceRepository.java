package projet.core.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.core.data.entities.Etudiant;
import projet.core.data.entities.Presence;
import projet.core.data.entities.Seance;

import java.util.Optional;

public interface PresenceRepository extends JpaRepository<Presence,Long> {
    Optional<Presence> findByIsArchivedFalseAndSeanceAndEtudiant(Seance seance, Etudiant etudiant);
}
