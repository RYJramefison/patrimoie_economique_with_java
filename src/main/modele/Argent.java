package main.modele;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Argent {
    private final double montant;
    private final Devise devise;

    public Argent additionner(Argent that){
        var converti = that.convertir(this.devise);
        return new Argent( this.getMontant() + converti.getMontant(), this.getDevise());
    }

    public Argent soustraction(Argent that){
        var converti = that.convertir(this.devise);
        return new Argent( this.getMontant() - converti.getMontant(), this.getDevise());
    }

    public Argent multiplier(double facteur){
        return new Argent( this.getMontant() * facteur, this.getDevise());
    }

    public static Argent ariary(double montant){
        return new Argent(montant, Devise.ARIARY);
    }

    public static Argent euro(double montant){
        return new Argent(montant, Devise.EURO);
    }

    public static Argent dollar(double montant){
        return new Argent(montant, Devise.US_DOLLAR);
    }

    public Argent convertir(Devise nouvelleDevise){
        this.devise.getTauxDeChangeVersAriary();
        return new Argent((this.getMontant() * this.devise.getTauxDeChangeVersAriary()) / nouvelleDevise.getTauxDeChangeVersAriary(), nouvelleDevise);
    }
}
