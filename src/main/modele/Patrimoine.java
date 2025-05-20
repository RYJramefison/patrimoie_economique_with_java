package main.modele;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter

public class Patrimoine {
    private final Personne possesseur;
    private final LocalDate aDateDe;
    private final Set<Possession> possessions;

    public Patrimoine projectionFuture(LocalDate dateFuture) {

        Set<Possession> possessionsFuture = possessions.stream().map(possession ->
                possession.projectionFuture(dateFuture))
                .collect(Collectors.toSet());

        return new Patrimoine(possesseur, dateFuture, possessionsFuture);
    }

    public static void main(String[] args) {
        Personne john = new Personne("John");
        Argent argentPourPC = new Argent(1000000, Devise.ARIARY);
        Materiel PC = new Materiel("PC asus rog", LocalDate.of(2025,5,15),argentPourPC,0.1,LocalDate.of(2025,5,15));

        Argent argentPourVetement = new Argent(20000, Devise.ARIARY);
        Materiel vetement = new Materiel("vetement", LocalDate.of(2025,5,15),argentPourVetement,0.2, LocalDate.of(2025,5,15));

//        Argent argentPourLeLoyer = new Argent(-200000, Devise.ARIARY);
//        TrainDeVie loyer = new TrainDeVie("Loyer", LocalDate.of(2025,5,15),argentPourLeLoyer);

        Patrimoine patrimoineDeJohn = new Patrimoine(john,LocalDate.of(2025,5,15),Set.of(PC, vetement));

//        double projectionFutureDeJohn = patrimoineDeJohn.projectionFuture(LocalDate.of(2031, 1, 1));
//        System.out.println(projectionFutureDeJohn);

    }
}
