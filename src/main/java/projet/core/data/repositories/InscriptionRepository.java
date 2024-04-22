package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.core.data.entities.AnneeScolaire;
import projet.core.data.entities.Classe;
import projet.core.data.entities.Etudiant;
import projet.core.data.entities.Inscription;

import java.util.Optional;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
    Page<Inscription> findAllByIsArchivedFalse(Pageable pageable);
    @Query("SELECT i FROM Inscription i "+
            "WHERE i.isArchived = false "+
            "AND i.anneeScolaire.isActive = true "+
            "AND (:classe IS NULL OR i.classe = :classe)")
    Page<Inscription> findAllByAnneeActiveAndClasse(@Param("classe")Classe classe,
                                Pageable pageable);
    Optional<Inscription> findByIsArchivedFalseAndAnneeScolaireAndEtudiant(AnneeScolaire anneeScolaire, Etudiant etudiant);
}
