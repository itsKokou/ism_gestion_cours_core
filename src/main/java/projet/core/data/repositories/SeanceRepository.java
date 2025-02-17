package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.core.data.entities.*;

import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance,Long> {
    Page<Seance> findAllByIsArchivedFalse(Pageable pageable);
    @Query("SELECT s FROM Seance s "+
            "JOIN s.cours c "+
            "JOIN c.classes cl "+
            "WHERE s.isArchived = false "+
            "AND :classe IS NULL OR cl = :classe "+
            "AND c.anneeScolaire.isActive = true"
    )
    List<Seance> findAllByClasse(@Param("classe") Classe classe);

    @Query("SELECT s FROM Seance s "+
            "JOIN s.cours c "+
            "JOIN c.classes cl "+
            "WHERE s.isArchived = false "+
            "AND (:classe IS NULL OR cl = :classe) "+
            "AND c.anneeScolaire.isActive = true "+
            "AND (:professeur IS NULL OR (s.professeur IS NULL or s.professeur = :professeur) ) "+
            "AND (:professeur IS NULL OR (s.professeur IS NULL and c.professeur = :professeur) ) "
    )
    List<Seance> findAllByClasseAndProfesseur(@Param("classe") Classe classe,
                                              @Param("professeur") Professeur professeur);

    @Query("SELECT i FROM Inscription i "+
            "JOIN i.classe cl "+
            "JOIN cl.courss co "+
            "JOIN co.seances s "+
            "WHERE s = :seance "+
            "AND i.anneeScolaire.isActive = true"
    )
    Page<Inscription> findLesEtudiantsBySeance(@Param("seance") Seance seance,  Pageable pageable);
    List<Seance> findAllBySalleAndCours_AnneeScolaire_IsActiveTrue(Salle salle);
}
