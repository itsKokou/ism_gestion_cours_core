package projet.core.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "etudiants")
@Builder
@DiscriminatorValue(value = "Etudiant")
public class Etudiant extends AppUser{

    @Column(length = 20, nullable = false, unique = true)
    private String matricule;
    @Column(length = 30, nullable = false)
    private String tuteur;
    @Column(length = 20, nullable = false, unique = true)
    private String photo;
    @OneToMany(mappedBy = "etudiant")
    private List<Inscription> inscriptions;
    @OneToMany(mappedBy = "etudiant")
    private List<Absence> absences;
    @OneToMany(mappedBy = "etudiant")
    private List<Presence> presences;
}
