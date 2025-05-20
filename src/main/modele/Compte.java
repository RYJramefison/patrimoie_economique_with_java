package main.modele;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Compte extends Possession{
    private final Set<TrainDeVie> trainDeVies;
    private final LocalDate dateDeCreation;

    public Compte(String nom, LocalDate aDateDe, Argent valeur, LocalDate dateDeCreation) {
        super(nom, aDateDe, valeur);
        this.dateDeCreation = dateDeCreation;
        this.trainDeVies = new HashSet<>();
    }

    @Override
    public Possession projectionFuture(LocalDate dateFuture) {
        if (this.dateDeCreation.isAfter(dateFuture)) {
            return new Compte(
                this.nom, dateFuture,
                Argent.ariary(0d), this.dateDeCreation
            );
        }

        Argent sommeTotalTrainDeVie = this.trainDeVies.stream().map(trainDeVie ->
            trainDeVie.projectionFuture(dateFuture).valeur)
            .reduce(Argent::additionner).orElse(Argent.ariary(0d));

        return new Compte(
                this.nom, dateFuture,
                this.valeur.soustraction(sommeTotalTrainDeVie),
                this.dateDeCreation
        );
    }

    public void financer(TrainDeVie trainDeVie) {
        this.trainDeVies.add(trainDeVie);
    }
}
