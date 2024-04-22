package projet.core.services;

import projet.core.data.entities.Etudiant;

import java.util.Optional;

public interface EtudiantService extends Service<Etudiant,Long> {
    Optional<Etudiant> getEtudiantByMatricule(String matricule);
}
