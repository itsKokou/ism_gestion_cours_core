package projet.core.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.core.data.entities.Module;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModuleResponseDto {
    private Long id;
    private String libelle;

    public static ModuleResponseDto toDto(Module module) {

        return ModuleResponseDto
                .builder()
                .id(module.getId())
                .libelle(module.getLibelle())
                .build();

    }
}


