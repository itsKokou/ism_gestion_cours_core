package projet.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface Service<T,ID> {
    T save(T data);
    Page<T> getAll(Pageable pageable);
    Optional<T> show(ID dataID);
}
