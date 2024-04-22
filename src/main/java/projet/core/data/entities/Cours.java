package projet.core.data.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import projet.core.data.enums.EtatCours;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "courss")
@Builder
public class Cours extends AbstractEntity{
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Enumerated(value = EnumType.STRING)
    private EtatCours etat;
    @Column(nullable = false)
    private Integer nbreHeureTotal;
    @Column(nullable = false)
    private Integer nbreHeurePlanifie;
    @Column(nullable = false)
    private Integer nbreHeureRestantPlan;
    @Column(nullable = false)
    private Integer nbreHeureRealise;

    @ManyToOne
    @JoinColumn(nullable = false)
    private AnneeScolaire anneeScolaire;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Semestre semestre;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Module module;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Professeur professeur;
    @ManyToMany
    private List<Classe> classes;
    @OneToMany(mappedBy = "cours")
    private List<Seance> seances;

}
