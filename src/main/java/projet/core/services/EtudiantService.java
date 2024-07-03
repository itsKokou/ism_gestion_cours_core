package projet.core.services;

import projet.core.data.entities.Etudiant;

import java.util.List;
import java.util.Optional;

public interface EtudiantService extends Service<Etudiant,Long> {
    Optional<Etudiant> getEtudiantByMatricule(String matricule);
    List<Etudiant> getEtudiantWithAbsence();
}
