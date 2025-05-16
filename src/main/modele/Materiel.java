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
        double valeurActuel = this.getValeur().getMontant();
        int nombreAnnee = Period.between(this.dateDAcquisition, dateFuture).getYears();

        // creer une condition qui verifie si la dateFuture et plus ancien que la dateDAppreciation

        // methode 1
        for (int i = 0; i < nombreAnnee; i++) {
            double nouvelleValeur = valeurActuel - (valeurActuel * this.tauxDappreciation);
            valeurActuel = nouvelleValeur;
        }

        // methode 2
//        double valeurFuture = this.getValeur().getMontant() * Math.pow((1 - this.tauxDappreciation / 100), nombreAnnee);

        Argent argentActuel = new Argent(valeurActuel,this.getValeur().getDevise());

        Materiel materielActuel = new Materiel(this.getNom(), dateFuture, argentActuel, this.tauxDappreciation , this.dateDAcquisition);
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