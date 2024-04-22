package projet.core.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.core.data.entities.Inscription;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscriptionEtudiantResponseDto {
    private Long id;
    private String matricule;
    private String nomComplet;
    private String email;
    private String tuteur;
    private String classe;

    public static InscriptionEtudiantResponseDto toDto(Inscription inscription) {

        return InscriptionEtudiantResponseDto
                .builder()
                .id(inscription.getEtudiant().getId())
                .matricule(inscription.getEtudiant().getMatricule())
                .nomComplet(inscription.getEtudiant().getNomComplet())
                .email(inscription.getEtudiant().getLogin())
                .tuteur(inscription.getEtudiant().getTuteur())
                .classe(inscription.getClasse().getLibelle())
                .build();

    }
}
