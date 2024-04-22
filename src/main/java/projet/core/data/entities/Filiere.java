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
@Table(name = "filieres")
@Builder
public class Filiere extends AbstractEntity{
    @Column(length = 20, unique = true, nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "filiere")
    private List<Classe> classes;
}
