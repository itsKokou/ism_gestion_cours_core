package projet.core.data.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import projet.core.data.enums.EtatDeclaration;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "declarations")
@Builder
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Column(nullable = false)
    private String motif;
    @Column(nullable = false)
    private String description;
    @Enumerated(value = EnumType.STRING)
    private EtatDeclaration etat;

    @ManyToOne
    @JoinColumn(nullable = false)
    private AppUser user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Seance seance;
}
