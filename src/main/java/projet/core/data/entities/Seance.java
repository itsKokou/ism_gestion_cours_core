package projet.core.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "seances")
@Builder
public class Seance extends AbstractEntity{
    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean isAbsence;
    @Column(nullable = true)
    private String codeSeance;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private LocalTime heureD;
    @Column(nullable = false)
    private LocalTime heureF;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cours cours;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Salle salle;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Professeur professeur;
    @OneToMany(mappedBy = "seance")
    private List<Absence> absences;
    @OneToMany(mappedBy = "seance")
    private List<Presence> presences;

}
