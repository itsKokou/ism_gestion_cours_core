package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.core.data.entities.Classe;
import projet.core.data.entities.Filiere;
import projet.core.data.entities.Niveau;

public interface ClasseRepository extends JpaRepository<Classe,Long> {
    Page<Classe> findAllByIsArchivedFalseAndIsPlannedTrue(Pageable pageable);

    @Query("SELECT c FROM Classe c " +
            "WHERE c.isPlanned = true " +
            "AND (:niveau IS NULL OR c.niveau = :niveau) " +
            "AND (:filiere IS NULL OR c.filiere = :filiere)")
    Page<Classe> findByNiveauAndFiliere(@Param("niveau") Niveau niveau,
                                        @Param("filiere") Filiere filiere,
                                        Pageable pageable);
}
