package main.modele;

import java.time.LocalDate;

public final class TrainDeVie extends Possession {


    public TrainDeVie(String nom, LocalDate aDateDe, Argent valeur) {
        super(nom, aDateDe, valeur);
    }

    @Override
    public Possession projectionFuture(LocalDate dateFuture) {
        return null;
    }
}
