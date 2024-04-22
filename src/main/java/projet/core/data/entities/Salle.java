package projet.core.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "salles")
@Builder
public class Salle extends AbstractEntity{
    @Column(length = 20, unique = true, nullable = false)
    private String libelle;
    @Column(nullable = false)
    private Integer nbrePlace;
    @Column(nullable = false, columnDefinition = "boolean default false")
    protected Boolean isPlanned;

    @OneToMany(mappedBy = "salle")
    private List<Seance> seances;
}
