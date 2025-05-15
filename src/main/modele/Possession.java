package main.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Getter

public abstract sealed class Possession permits Compte, Materiel, TrainDeVie {
    private final String nom;
    private final LocalDate aDateDe;
    private final Argent valeur;

    public abstract Possession projectionFuture(LocalDate dateFuture);
}
