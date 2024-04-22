package projet.core.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "classes")
@Builder
public class Classe extends AbstractEntity{
    @Column(length = 20, unique = true, nullable = false)
    private String libelle;
    @Column(nullable = false)
    private Integer effectif;
    @Column(nullable = false, columnDefinition = "boolean default false")
    protected Boolean isPlanned;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Niveau niveau;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Filiere filiere;
    @OneToMany(mappedBy = "classe")
    private List<Inscription> inscriptions;
    @OneToMany(mappedBy = "classe")
    private List<Enseignement> enseignements;
    @ManyToMany(mappedBy = "classes")
    private List<Cours> courss;

}
