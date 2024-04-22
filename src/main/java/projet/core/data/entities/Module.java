package projet.core.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "modules")
@Builder
public class Module extends AbstractEntity {

    @Column(length = 20, unique = true, nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "module")
    private List<Cours> courss;
    @ManyToMany(mappedBy = "modules")
    private List<Enseignement> enseignements;
}
