package main.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Getter

public abstract sealed class Possession permits Compte, Materiel, TrainDeVie {
    protected final String nom;
    protected final LocalDate aDateDe;
    protected final Argent valeur;

    public abstract Possession projectionFuture(LocalDate dateFuture);

    public Argent valeurFuture(LocalDate dateFuture, Devise devise){
        return projectionFuture(dateFuture).getValeur().convertir(devise);
    }


}
