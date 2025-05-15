package modele;


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
        System.out.println(years);
        for (int i = 0; i < years; i++) {
            System.out.println(i);
            double nouvelleValeur = valeurActuel - (valeurActuel * this.tauxDappreciation);
            valeurActuel = nouvelleValeur;
        }

        Argent argentActuel = new Argent(valeurActuel,this.getValeur().getDevise());

        Materiel materielActuel = new Materiel(this.getNom(), this.getADateDe(), argentActuel, this.tauxDappreciation );
        if (materielActuel instanceof Possession) {
            System.out.println(valeurActuel);
            return materielActuel;
        }
        return null;
    }



    public static void main(String[] args) {
        Argent argent = new Argent(1000000, Devise.ARIARY);
        Materiel materiel = new Materiel("PC asus rog", LocalDate.of(2025,5,15),argent,0.1);

        System.out.println((Materiel) materiel.projectionFuture(LocalDate.of(2031, 1, 1)));

    }

}

// 6 553.6
// 597 043,6
// 590 490