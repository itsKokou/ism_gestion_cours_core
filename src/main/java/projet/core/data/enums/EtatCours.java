package projet.core.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EtatCours {
    Encours(0),
    Termine(1);

    private final Integer indexEnumEtat;
}

