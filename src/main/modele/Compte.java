package main.modele;

import java.time.LocalDate;

public final class Compte extends Possession{

    public Compte(String nom, LocalDate aDateDe, Argent valeur) {
        super(nom, aDateDe, valeur);
    }

    @Override
    public Possession projectionFuture(LocalDate dateFuture) {
        return null;
    }
}
