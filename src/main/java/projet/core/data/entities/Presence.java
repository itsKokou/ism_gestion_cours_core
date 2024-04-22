package projet.core.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "presences")
@Builder
public class Presence extends AbstractEntity{

    @ManyToOne
    @JoinColumn(nullable = false)
    private Etudiant etudiant;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Seance seance;
}
