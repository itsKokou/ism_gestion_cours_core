package projet.core.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.core.data.entities.Declaration;
import projet.core.data.entities.Professeur;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeclarationResponseDto {
    private Long id;
    private Long userId;
    private Long seanceId;
    private String date;
    private String titre;
    private String cours;
    private String email;
    private String user;
    private String motif;
    private String description;
    private String etat;

    public static DeclarationResponseDto toDto(Declaration declaration) {
        String title = "Etudiant";
        if (declaration.getUser().getClass()== Professeur.class){
            title = "Professeur";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return DeclarationResponseDto
                .builder()
                .id(declaration.getId())
                .userId(declaration.getUser().getId())
                .seanceId(declaration.getSeance().getId())
                .date(sdf.format(declaration.getCreatedAt()))
                .titre(title)
                .cours(declaration.getSeance().getCours().getModule().getLibelle())
                .email(declaration.getUser().getLogin())
                .user(declaration.getUser().getNomComplet())
                .motif(declaration.getMotif())
                .description(declaration.getDescription())
                .etat(declaration.getEtat().name())
                .build();
    }
}


