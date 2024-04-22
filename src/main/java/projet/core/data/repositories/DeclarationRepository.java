package projet.core.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.core.data.entities.Declaration;
import projet.core.data.enums.EtatDeclaration;

public interface DeclarationRepository extends JpaRepository<Declaration,Long> {
    Page<Declaration> findAll(Pageable pageable);
    @Query("SELECT d FROM Declaration d "+
            "JOIN d.seance s "+
            "JOIN d.user u "+
            "JOIN u.roles r "+
            "JOIN s.cours c "+
            "WHERE d.etat = :etat "+
            "AND c.anneeScolaire.isActive = true "+
            "AND r.roleName = 'ROLE_ETUDIANT'"

    )
    Page<Declaration> findEtudiantDeclarationsByEtat(@Param("etat") EtatDeclaration etat,
                                             Pageable pageable);
}
