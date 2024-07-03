package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.core.data.entities.Classe;
import projet.core.data.entities.Enseignement;
import projet.core.data.entities.Module;
import projet.core.data.entities.Professeur;

public interface EnseignementRepository extends JpaRepository<Enseignement,Long> {
    Page<Enseignement> findAll(Pageable pageable);
    @Query("SELECT DISTINCT e.classe FROM Enseignement e "+
            "WHERE e.anneeScolaire.isActive = true "+
            "AND e.professeur = :professeur"
    )
    Page<Classe> findClasseByProfesseur(@Param("professeur") Professeur professeur, Pageable pageable);

    @Query("SELECT DISTINCT m FROM Module m " +
            "JOIN m.enseignements e " +
            "WHERE m.isArchived = false " +
            "AND e.professeur = :professeur " +
            "AND e.anneeScolaire.isActive = true")
    Page<Module> findModuleByProfesseur(@Param("professeur") Professeur professeur, Pageable pageable);
    Enseignement findByClasseAndProfesseurAndAnneeScolaireIsActiveTrue(Classe classe, Professeur professeur);

}
