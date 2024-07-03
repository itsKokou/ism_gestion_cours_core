package projet.core.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Module module)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getId(), module.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLibelle());
    }
}
