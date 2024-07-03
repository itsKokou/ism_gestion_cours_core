package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.core.data.entities.Module;
import projet.core.data.entities.Professeur;

import java.util.List;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    Page<Professeur> findAllByIsArchivedFalse(Pageable pageable);

    @Query("SELECT DISTINCT p.grade FROM Professeur p")
    List<String> findAllGrades();

    @Query("SELECT p FROM Professeur p "+
            "WHERE p.isArchived = false AND p.isPlanned = :planned "+
            "AND (:grade IS NULL OR p.grade = :grade) "+
            "AND (:portable IS NULL OR p.portable = :portable)"
    )
    Page<Professeur> findAllByGradeAndPortableAndPlanned(@Param("grade") String grade,
                                               @Param("portable") String portable,
                                               @Param("planned") Boolean planned,
                                               Pageable pageable);

    @Query("SELECT DISTINCT p FROM Professeur p "+
            "LEFT JOIN p.enseignements e "+
            "LEFT JOIN e.modules m "+
            "WHERE p.isArchived = false AND p.isPlanned = true AND m.isArchived = false "+
            "AND (:module IS NULL OR m = :module ) "+
            "AND (:grade IS NULL OR p.grade = :grade) "+
            "AND (:portable IS NULL OR p.portable LIKE %:portable%) "+
            "AND e.anneeScolaire.isActive = true"
    )
    Page<Professeur> findAllByModuleAndGradeAndPortable(@Param("module") Module module,
                                                    @Param("grade") String grade,
                                                    @Param("portable") String portable,
                                                    Pageable pageable);

    @Query("SELECT p FROM Professeur p "+
            "JOIN p.enseignements e "+
            "JOIN e.modules m "+
            "WHERE p.isArchived = false AND p.isPlanned = true "+
            "AND e.anneeScolaire.isActive = true "+
            "AND m= :module "
    )
    Page<Professeur> findAllByModule(@Param("module") Module module,Pageable pageable);

}
