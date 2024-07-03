package projet.core.services;

import projet.core.data.entities.Niveau;
import projet.core.data.entities.Semestre;

public interface SemestreService extends Service<Semestre,Long> {
    Semestre getSemestreActuelleByNiveau(Niveau niveau);
}
