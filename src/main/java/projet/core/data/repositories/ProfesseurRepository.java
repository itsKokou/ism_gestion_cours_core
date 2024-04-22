package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.core.data.entities.Professeur;

import java.util.List;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    Page<Professeur> findAllByIsArchivedFalse(Pageable pageable);

    @Query("SELECT DISTINCT p.grade FROM Professeur p")
    List<String> findAllGrades();

    @Query("SELECT p FROM Professeur p "+
            "WHERE p.isArchived = false AND p.isPlanned = true "+
            "AND (:grade IS NULL OR p.grade = :grade) "+
            "AND (:portable IS NULL OR p.portable = :portable)"
    )
    Page<Professeur> findAllByGradeAndPortable(@Param("grade") String grade,
                                               @Param("portable") String portable,
                                               Pageable pageable);
}
