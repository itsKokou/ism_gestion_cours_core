package projet.core.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.core.data.entities.Classe;
import projet.core.data.entities.Cours;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoursResponseDto {
    private Long id;
    private Date date;
    private String module;
    private String professeur;
    private String classes;
    private String semestre;
    private int nbreHeureTotal;
    private int nbreHeurePlanifie;
    private int nbreHeureRealise;
    private String etat;

    public static CoursResponseDto toDto(Cours cours) {
        String classes = "";
        for (Classe classe : cours.getClasses()){
            classes += "-" + classe.getLibelle()+" ";
        }
        return CoursResponseDto
                .builder()
                .id(cours.getId())
                .date(cours.getCreatedAt())
                .module(cours.getModule().getLibelle())
                .professeur(cours.getProfesseur().getNomComplet())
                .classes(classes)
                .semestre(cours.getSemestre().getLibelle())
                .nbreHeureTotal(cours.getNbreHeureTotal())
                .nbreHeurePlanifie(cours.getNbreHeurePlanifie())
                .nbreHeureRealise(cours.getNbreHeureRealise())
                .etat(cours.getEtat().name())
                .build();

    }
}


