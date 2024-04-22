package projet.core.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.core.data.entities.Classe;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClasseResponseDto {
    private Long id;
    private String libelle;
    private String niveau;
    private String filiere;
    private int effectif;

    public static ClasseResponseDto toDto(Classe classe) {

        return ClasseResponseDto
                .builder()
                .id(classe.getId())
                .libelle(classe.getLibelle())
                .niveau(classe.getNiveau().getLibelle())
                .filiere(classe.getFiliere().getLibelle())
                .effectif(classe.getEffectif())
                .build();

    }
}


