package projet.core.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.core.data.entities.Presence;

public interface PresenceRepository extends JpaRepository<Presence,Long> {

}
