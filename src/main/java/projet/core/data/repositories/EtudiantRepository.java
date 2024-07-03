package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projet.core.data.entities.Etudiant;

import java.util.List;
import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Optional<Etudiant> findEtudiantByMatricule(String matricule);
    Page<Etudiant> findAllByIsArchivedFalse(Pageable pageable);

    @Query("SELECT DISTINCT e FROM Etudiant e " +
            "JOIN e.absences a "+
            "JOIN a.seance s "+
            "JOIN s.cours c "+
            "JOIN e.inscriptions i "+
            "WHERE e.isArchived= false AND i.anneeScolaire.isActive=true "+
            "AND i.isArchived=false "+
            "AND c.anneeScolaire.isActive = true"
    )
    List<Etudiant> findEtudiantWithAbsence();

}
