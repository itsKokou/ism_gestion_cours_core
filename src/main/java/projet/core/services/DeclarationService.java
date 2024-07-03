package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.core.data.entities.AppUser;
import projet.core.data.entities.Declaration;
import projet.core.data.entities.Seance;
import projet.core.data.enums.EtatDeclaration;

public interface DeclarationService extends Service<Declaration,Long> {
    Page<Declaration> getDeclarationsByEtatAndUserRole(EtatDeclaration etat,String roleName, Pageable pageable);
    Page<Declaration> getDeclarationsByUser(AppUser user, Pageable pageable);
    Declaration getDeclarationsByUserAndSeance(AppUser user, Seance seance);
}
