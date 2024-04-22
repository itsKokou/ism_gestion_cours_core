package projet.core.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "semestres")
@Builder
public class Semestre extends AbstractEntity {
    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;
    @Column(length = 20, nullable = false, unique = true)
    private String libelle;

    @OneToMany(mappedBy = "semestre")
    private List<Cours> courss;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Niveau niveau;
}
