package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.core.data.entities.Salle;

public interface SalleService extends Service<Salle,Long> {
    Page<Salle> getAllByPlanned(Boolean planned,Pageable pageable);
}
