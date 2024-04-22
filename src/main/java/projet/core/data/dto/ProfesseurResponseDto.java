package projet.core.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.core.data.entities.Professeur;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfesseurResponseDto {
    private Long id;
    private String nomComplet;
    private String email;
    private String portable;
    private String grade;

    public static ProfesseurResponseDto toDto(Professeur prof) {

        return ProfesseurResponseDto
                .builder()
                .id(prof.getId())
                .nomComplet(prof.getNomComplet())
                .email(prof.getLogin())
                .portable(prof.getPortable())
                .grade(prof.getGrade())
                .build();

    }
}
