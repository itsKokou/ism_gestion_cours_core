package projet.core.services;

import projet.core.data.entities.AnneeScolaire;

public interface AnneeScolaireService extends Service<AnneeScolaire,Long> {
    AnneeScolaire getAnneeActuelle();
}
