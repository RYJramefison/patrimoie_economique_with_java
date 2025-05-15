package test;


import main.modele.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

public class MaterielTest {

    @Test
    public void testProjectionFuturePourMateriel() {
        Argent argent = new Argent(1000000, Devise.ARIARY);
        Materiel materiel = new Materiel("PC asus rog", LocalDate.of(2025,5,15),argent,0.1);
        Materiel reponseAttendue = new Materiel("PC asus rog", LocalDate.of(2025,5,15), new Argent(590490.0,Devise.ARIARY),0.1);


        Possession possessionActuel = materiel.projectionFuture(LocalDate.of(2031, 1, 1));

        Assertions.assertEquals(reponseAttendue,possessionActuel);
    }
}
