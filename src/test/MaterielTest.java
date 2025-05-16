package test;


import main.modele.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

public class MaterielTest {

    @Test
    public void test_projection_future_d_un_Materiel() {
        var argent = new Argent(1000000, Devise.ARIARY);
        var materiel = new Materiel("PC asus rog", LocalDate.of(2025,5,15),argent,0.1, LocalDate.of(2025,5,15));
        var reponseAttendue = new Materiel("PC asus rog", LocalDate.of(2025,5,15), new Argent(590490.0,Devise.ARIARY),0.1,LocalDate.of(2025,5,15));


        Possession possessionActuel = materiel.projectionFuture(LocalDate.of(2031, 1, 1));

        Assertions.assertEquals(reponseAttendue,possessionActuel);
    }

    @Test
    public void test_projection_future_d_un_Materiel_avec_donne_excacte() {
        var ordinateur = new Materiel("ordinateur", LocalDate.of(2021,10,26),Argent.ariary(2_000_000d),0.1d, LocalDate.of(2021,10,26));

        Possession possessionActuel = ordinateur.projectionFuture(LocalDate.of(2023, 1, 1));

        Assertions.assertEquals(1_800_000d,possessionActuel.getValeur().getMontant());
    }
}
