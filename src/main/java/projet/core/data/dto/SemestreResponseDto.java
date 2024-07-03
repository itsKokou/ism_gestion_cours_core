package projet.core.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.core.data.entities.Semestre;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SemestreResponseDto {
    private Long id;
    private String libelle;
    private Boolean isActive;
    private NiveauResponseDto niveau;

    public static SemestreResponseDto toDto(Semestre semestre) {

        return SemestreResponseDto
                .builder()
                .id(semestre.getId())
                .libelle(semestre.getLibelle())
                .isActive(semestre.getIsActive())
                .niveau(NiveauResponseDto.toDto(semestre.getNiveau()))
                .build();

    }
}


