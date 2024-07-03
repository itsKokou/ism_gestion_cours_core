package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.core.data.entities.*;
import projet.core.data.enums.EtatCours;

public interface CoursRepository extends JpaRepository<Cours,Long> {
    Page<Cours> findAllByIsArchivedFalse(Pageable pageable);
    Page<Cours> findAllByIsArchivedFalseAndAnneeScolaire(AnneeScolaire anneeScolaire, Pageable pageable);
    Page<Cours> findAllByIsArchivedFalseAndAnneeScolaireAndEtat(AnneeScolaire anneeScolaire, EtatCours etatCours, Pageable pageable);

    @Query("SELECT DISTINCT c FROM Cours c " +
            "JOIN c.classes cl "+
            "WHERE c.isArchived = false " +
            "AND c.anneeScolaire= :anneeScolaire "+
            "AND (:etat IS NULL OR c.etat = :etat) "+
            "AND (:semestre IS NULL OR c.semestre = :semestre) "+
            "AND (:classe IS NULL OR cl = :classe) "+
            "AND (:prof IS NULL OR c.professeur = :prof) "
    )
    Page<Cours> findAllByAnneeAndEtatAndSemestreAndClasseAndProf(
                                                    @Param("anneeScolaire") AnneeScolaire anneeScolaire,
                                                    @Param("etat") EtatCours etat,
                                                    @Param("semestre") Semestre semestre,
                                                    @Param("classe") Classe classe,
                                                    @Param("prof") Professeur prof,
                                                    Pageable pageable);

    Page<Cours> findCoursByAnneeScolaireIsActiveTrueAndProfesseur(Professeur professeur,Pageable pageable);

}
