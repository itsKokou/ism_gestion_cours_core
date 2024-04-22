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
@Table(name = "niveaux")
@Builder
public class Niveau extends AbstractEntity{

    @Column(length = 20, unique = true, nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "niveau")
    private List<Classe> classes;
    @OneToMany(mappedBy = "niveau")
    private List<Semestre> semestres;

}
