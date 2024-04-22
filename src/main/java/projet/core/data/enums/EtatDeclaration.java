package projet.core.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EtatDeclaration {
    Enattente(0),
    Refuse(1),
    Accepte(2);

    private final Integer indexEnumEtat;
}

