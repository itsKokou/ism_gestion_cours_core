package projet.core.data.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue(value = "AppUser")
public class AppUser extends AbstractEntity {
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String nomComplet;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> roles = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Declaration> declarations;

    public AppUser(String login, String password) {
        this.login = login;
        this.password = password;
        this.isArchived = true;
    }
}
