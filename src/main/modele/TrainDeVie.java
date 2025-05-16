package main.modele;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.Year;

public final class TrainDeVie extends Possession {
    private final Compte financeur;
    private final int jourDOperation;
    private final LocalDate debutDelaPonction;

    public TrainDeVie(String nom, LocalDate aDateDe, Argent valeur, Compte financeur, int jourDOperation, LocalDate debutDelaPonction) {
        super(nom, aDateDe, valeur);
        this.financeur = financeur;
        this.jourDOperation = jourDOperation;
        this.debutDelaPonction = debutDelaPonction;
    }

    @Override
    public Possession projectionFuture(LocalDate dateFuture) {
        if (dateFuture.isBefore(debutDelaPonction)) {
            return new TrainDeVie(
                    this.nom, dateFuture,
                    Argent.ariary(0d), this.financeur,
                    this.jourDOperation, this.debutDelaPonction
            );
        }

        long moisEcoulee = Period.between(debutDelaPonction,dateFuture).getMonths();
//        long moisEcoulee = MONTHS.between(debutDelaPonction,dateFuture).getMonths();

        if (dateFuture.getDayOfMonth() >= jourDOperation) {

            Argent valeurFuture = financeur.getValeur().soustraction(valeur.multiplier(moisEcoulee));

        }
        return null;
    }
}
