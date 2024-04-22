package projet.core.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "enseignements")
@Builder
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private AnneeScolaire anneeScolaire;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Professeur professeur;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Classe classe;
    @ManyToMany
    private List<Module> modules;

}
