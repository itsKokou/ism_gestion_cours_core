package projet.core.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "professeurs")
@Builder
@DiscriminatorValue(value = "Professeur")
public class Professeur extends AppUser{

    @Column(length = 20, nullable = false, unique = true)
    private String portable;
    @Column(length = 20, nullable = false)
    private String grade;
    @Column(nullable = false, columnDefinition = "boolean default false")
    protected Boolean isPlanned;

    @OneToMany(mappedBy = "professeur")
    private List<Cours> courss;
    @OneToMany(mappedBy = "professeur")
    private List<Enseignement> enseignements;
    @OneToMany(mappedBy = "professeur")
    private List<Seance> seances;
}
