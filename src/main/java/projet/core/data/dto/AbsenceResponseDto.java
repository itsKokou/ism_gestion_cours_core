package projet.core.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.core.data.entities.Absence;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AbsenceResponseDto {
    private Long id;
    private String date;
    private String cours;
    private String professeur;
    private String horaire;
    private String semestre;
    private String matricule;
    private String etudiant;


    public static AbsenceResponseDto toDto(Absence absence) {
        String horaire = absence.getSeance().getHeureD().format(DateTimeFormatter.ofPattern("HH:mm")) + " à "+
                absence.getSeance().getHeureF().format(DateTimeFormatter.ofPattern("HH:mm"));
        String prof = absence.getSeance().getProfesseur()!=null? absence.getSeance().getProfesseur().getNomComplet() : absence.getSeance().getCours().getProfesseur().getNomComplet();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return AbsenceResponseDto
                .builder()
                .id(absence.getId())
                .date(sdf.format(absence.getSeance().getDate()))
                .cours(absence.getSeance().getCours().getModule().getLibelle())
                .professeur(prof)
                .horaire(horaire)
                .semestre(absence.getSeance().getCours().getSemestre().getLibelle())
                .matricule(absence.getEtudiant().getMatricule())
                .etudiant(absence.getEtudiant().getNomComplet())
                .build();

    }
}


