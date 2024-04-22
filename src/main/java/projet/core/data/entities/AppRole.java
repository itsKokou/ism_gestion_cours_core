package projet.core.data.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
@Builder
public class AppRole  extends AbstractEntity {
    @Column(nullable = false, unique = true)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    List<AppUser> users;

    public AppRole(String roleName) {
        this.roleName = roleName;
        this.isArchived = true;
    }
}
