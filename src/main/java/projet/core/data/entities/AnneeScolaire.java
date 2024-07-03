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
@Table(name = "annee_scolaires")
@Builder
public class AnneeScolaire extends AbstractEntity{
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isActive;
    @Column(length = 20, nullable = false, unique = true)
    private String libelle;

    @OneToMany(mappedBy = "anneeScolaire")
    private List<Inscription> inscriptions;
    @OneToMany(mappedBy = "anneeScolaire")
    private List<Enseignement> enseignements;
    @OneToMany(mappedBy = "anneeScolaire")
    private List<Cours> courss;
}
