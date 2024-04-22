package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.core.data.entities.Declaration;
import projet.core.data.enums.EtatDeclaration;

public interface DeclarationService extends Service<Declaration,Long> {
    Page<Declaration> getEtudiantDeclarationsByEtat(EtatDeclaration etat, Pageable pageable);
}
