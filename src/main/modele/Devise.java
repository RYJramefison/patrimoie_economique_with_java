package main.modele;

import lombok.Getter;

@Getter
public enum Devise {
    EURO(4000d),
    US_DOLLAR(4000d),
    ARIARY(1d);

    private final double tauxDeChangeVersAriary;

    Devise(double tauxDeChangeVersAriary) {
        this.tauxDeChangeVersAriary = tauxDeChangeVersAriary;
    }

}
