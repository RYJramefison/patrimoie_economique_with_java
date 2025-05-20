package main.modele;


import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;

@Getter

public final class Materiel extends Possession {
    private final double tauxDappreciation;
    private final LocalDate dateDAcquisition;

    public Materiel(String nom, LocalDate aDateDe, Argent valeur, double tauxDappreciation, LocalDate dateDAcquisition) {
        super(nom, aDateDe, valeur);
        this.tauxDappreciation = tauxDappreciation;
        this.dateDAcquisition = dateDAcquisition;
    }


    @Override
    public Possession projectionFuture(LocalDate dateFuture) {

        if (dateFuture.isBefore(this.dateDAcquisition)) {
            return new Materiel(
                    this.nom, dateFuture, Argent.ariary(0d),
                    this.tauxDappreciation,this.dateDAcquisition
            );
        }

        int anneeEcoulee = Period.between(this.dateDAcquisition, dateFuture).getYears();

        Argent valeurDeLAmortissement = this.valeur.multiplier(this.tauxDappreciation);
        Argent valeurFuture = valeur.multiplier(valeurDeLAmortissement.getMontant());


//        double tauxDAppreciationAnnuel = Math.pow((1 - this.tauxDappreciation), anneeEcoulee);
//        Argent valeurFuture = valeur.multiplier(tauxDAppreciationAnnuel);

        return new Materiel(this.nom, dateFuture, valeurFuture,
                this.tauxDappreciation, this.dateDAcquisition
        );
    }



    public static void main(String[] args) {
        double tauxDAmortissement = 0.1d;

        double tauxDAmortissementAnnuel = Math.pow((1 - tauxDAmortissement), 5);
        System.out.println(tauxDAmortissementAnnuel);

        System.out.println(1_000_000 * tauxDAmortissementAnnuel);
    }

}

// 6 553.6
// 597 043,6
// 590 490