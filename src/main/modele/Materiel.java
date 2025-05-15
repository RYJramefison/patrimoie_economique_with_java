package main.modele;


import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;

@Getter

public final class Materiel extends Possession {
    private final double tauxDappreciation;

    public Materiel(String nom, LocalDate aDateDe, Argent valeur, double tauxDappreciation) {
        super(nom, aDateDe, valeur);
        this.tauxDappreciation = tauxDappreciation;
    }


    @Override
    public Possession projectionFuture(LocalDate dateFuture) {
        double valeurActuel = this.getValeur().getMontant();
        int years = Period.between(this.getADateDe(), dateFuture).getYears();
        for (int i = 0; i < years; i++) {
            double nouvelleValeur = valeurActuel - (valeurActuel * this.tauxDappreciation);
            valeurActuel = nouvelleValeur;
        }

        Argent argentActuel = new Argent(valeurActuel,this.getValeur().getDevise());

        Materiel materielActuel = new Materiel(this.getNom(), this.getADateDe(), argentActuel, this.tauxDappreciation );
        if (materielActuel instanceof Possession) {
            return materielActuel;
        }
        return null;
    }



    public static void main(String[] args) {

    }

}

// 6 553.6
// 597 043,6
// 590 490