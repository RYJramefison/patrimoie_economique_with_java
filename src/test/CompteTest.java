package test;

import main.modele.Argent;
import main.modele.Compte;
import main.modele.TrainDeVie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompteTest {

    @Test
    public void projection_future_compte() {
        var compteCourant = new Compte(
                "compte courant",
                LocalDate.of(2024,5,13),
                Argent.ariary(600_000d),
                LocalDate.of(2024,5,13)
        );

        var trainDeVie = new TrainDeVie(
            "depense",
                LocalDate.of(2024,5,13),
                Argent.ariary(500_000d),
                compteCourant,
            1,
                LocalDate.of(2024,5,13)
            );


        var actual = compteCourant.projectionFuture(LocalDate.of(2024,7,26));

        Assertions.assertEquals(-400_000d, actual.getValeur().getMontant());

    }
}
