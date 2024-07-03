package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.core.data.entities.*;
import projet.core.data.entities.Module;

public interface ClasseRepository extends JpaRepository<Classe,Long> {
    Page<Classe> findAllByIsArchivedFalse(Pageable pageable);
    Page<Classe> findAllByIsArchivedFalseAndIsPlannedTrue(Pageable pageable);

    @Query("SELECT c FROM Classe c " +
            "WHERE c.isPlanned = :planned " +
            "AND (:niveau IS NULL OR c.niveau = :niveau) " +
            "AND (:filiere IS NULL OR c.filiere = :filiere)")
    Page<Classe> findByNiveauAndFiliereAndPlanned(@Param("niveau") Niveau niveau,
                                        @Param("filiere") Filiere filiere,
                                        @Param("planned") Boolean planned,
                                        Pageable pageable);

    @Query("SELECT DISTINCT e.classe FROM Enseignement e "+
            "JOIN e.modules m "+
            "WHERE e.anneeScolaire.isActive = true "+
            "AND e.classe.niveau = :niveau "+
            "AND e.professeur = :professeur "+
            "AND m= :module"
    )
    Page<Classe> findByProfesseurAndModuleAndSemestreNiveau(@Param("professeur") Professeur professeur,
                                                      @Param("module") Module module,
                                                      @Param("niveau") Niveau niveau,
                                                      Pageable pageable);
}
