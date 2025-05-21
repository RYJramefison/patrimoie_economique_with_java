package main.modele;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
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
        if (dateDeCreation.isAfter(dateFuture)) {
            return new Compte(
                    nom,
                    dateFuture,
                    Argent.ariary(0d),
                    dateDeCreation
            );
        }

        Argent acc = calulerFinancementFutur(dateFuture);

        return  new Compte(
                nom,
                dateFuture,
                valeur.soustraction(acc),
                dateDeCreation
        );
    }

    private Argent calulerFinancementFutur(LocalDate dateFuture) {
        Argent acc = Argent.ariary(0d);
        Iterator<TrainDeVie> iterator = trainDeVies.iterator();
        while (iterator.hasNext()) {
            Argent valeur1 = iterator.next().projectionFuture(dateFuture).valeur;
            acc = acc.additionner(valeur1);
        }
        return acc;
    }

    public void financer(TrainDeVie trainDeVie) {
        this.trainDeVies.add(trainDeVie);
    }
}
