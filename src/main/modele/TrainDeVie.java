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

        this.financeur.financer(this);
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

        long moisEcoulee = Period.between(this.debutDelaPonction, dateFuture).getMonths();
//        long moisEcoulee = MONTHS.between(debutDelaPonction,dateFuture).getMonths();

//      1 jour de plus car cette fonction ne prend pas en compte le dernier jour du dateFuture
        long nombreDOperation = debutDelaPonction.datesUntil(dateFuture.plusDays(1))
                .filter( date -> date.getDayOfMonth() == this.jourDOperation
        ).count();

        Argent argentFuture = this.valeur.multiplier(nombreDOperation);

        return new TrainDeVie(
                this.nom, dateFuture, argentFuture, this.financeur,
                this.jourDOperation, this.debutDelaPonction
        );
    }
}
