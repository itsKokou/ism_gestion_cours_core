package projet.core.services;

import projet.core.data.entities.Etudiant;
import projet.core.data.entities.Presence;
import projet.core.data.entities.Seance;

import java.util.Optional;

public interface PresenceService extends Service<Presence,Long> {
    Optional<Presence> getBySeanceAndEtudiant(Seance seance, Etudiant etudiant);
}
