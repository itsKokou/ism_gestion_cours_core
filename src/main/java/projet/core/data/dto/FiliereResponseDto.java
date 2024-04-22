package projet.core.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.core.data.entities.Filiere;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FiliereResponseDto {
    private Long id;
    private String libelle;

    public static FiliereResponseDto toDto(Filiere filiere) {

        return FiliereResponseDto
                .builder()
                .id(filiere.getId())
                .libelle(filiere.getLibelle())
                .build();

    }
}


