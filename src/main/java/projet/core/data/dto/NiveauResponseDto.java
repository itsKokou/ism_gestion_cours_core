package projet.core.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.core.data.entities.Niveau;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NiveauResponseDto {
    private Long id;
    private String libelle;

    public static NiveauResponseDto toDto(Niveau niveau) {

        return NiveauResponseDto
                .builder()
                .id(niveau.getId())
                .libelle(niveau.getLibelle())
                .build();

    }
}


