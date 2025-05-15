package test;

import main.modele.Argent;
import main.modele.Devise;
import main.modele.Patrimoine;
import main.modele.Personne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

public class PatrimoineTest {

    @Test
    public void testProjectionFutur() {
        //
        Personne john = new Personne("John");

        Argent argentPourPC = new Argent(1000000, Devise.ARIARY);
        main.modele.Materiel PC = new main.modele.Materiel("PC asus rog", LocalDate.of(2025,5,15),argentPourPC,0.1);

        Argent argentPourVetement = new Argent(20000, Devise.ARIARY);
        main.modele.Materiel vetement = new main.modele.Materiel("vetement", LocalDate.of(2025,5,15),argentPourVetement,0.2);

        Patrimoine patrimoineDeJohn = new Patrimoine(john,LocalDate.of(2025,5,15), Set.of(PC, vetement));

//
        double projectionFutureDeJohn = patrimoineDeJohn.projectionFuture(LocalDate.of(2031, 1, 1));

//
        Assertions.assertEquals(597043.60, projectionFutureDeJohn);
    }
}
