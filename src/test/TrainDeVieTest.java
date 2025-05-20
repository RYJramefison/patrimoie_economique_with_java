package test;

import main.modele.Argent;
import main.modele.Compte;
import main.modele.TrainDeVie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TrainDeVieTest {

    @Test
    public void projection_future_de_train_de_vie() {
        var compteCourant = new Compte("compte courant", LocalDate.of(2024,5,13), Argent.ariary(600_000d));
        var trainDeVie = new TrainDeVie("vie quotidien", LocalDate.of(2024,5,13),Argent.ariary(500_000d), compteCourant,1,LocalDate.of(2024,5,13));

        var actual = trainDeVie.projectionFuture(LocalDate.of(2024,7,26));

        Assertions.assertEquals(1_000_000d, actual.getValeur().getMontant());
    }
}
