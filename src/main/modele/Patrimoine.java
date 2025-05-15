package main.modele;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter

public class Patrimoine {
    private final Personne possesseur;
    private final LocalDate aDateDe;
    private final Set<Possession> possessions;

    public double projectionFuture(LocalDate dateFuture) {

        double sommeDesValeursTotal = 0;

        double sommeDesValeursDansComptesEtTrainDeVie = 0;
        double sommeDesValeursDansMateriels = 0.0;

        for (Possession possession : this.possessions) {
                        switch (possession){
                            case Compte compte -> sommeDesValeursDansComptesEtTrainDeVie += possession.getValeur().getMontant();
                            case TrainDeVie trainDeVie -> sommeDesValeursDansComptesEtTrainDeVie += possession.getValeur().getMontant();
                            case Materiel materiel-> sommeDesValeursDansMateriels += materiel.projectionFuture(dateFuture).getValeur().getMontant();
                default -> throw new IllegalStateException("valeur invalid: " + possession);
            }
        }

        sommeDesValeursTotal = sommeDesValeursDansComptesEtTrainDeVie + sommeDesValeursDansMateriels ;
        return sommeDesValeursTotal;
    }

    public static void main(String[] args) {
        Personne john = new Personne("John");
        Argent argentPourPC = new Argent(1000000, Devise.ARIARY);
        Materiel PC = new Materiel("PC asus rog", LocalDate.of(2025,5,15),argentPourPC,0.1);

        Argent argentPourVetement = new Argent(20000, Devise.ARIARY);
        Materiel vetement = new Materiel("vetement", LocalDate.of(2025,5,15),argentPourVetement,0.2);

//        Argent argentPourLeLoyer = new Argent(-200000, Devise.ARIARY);
//        TrainDeVie loyer = new TrainDeVie("Loyer", LocalDate.of(2025,5,15),argentPourLeLoyer);

        Patrimoine patrimoineDeJohn = new Patrimoine(john,LocalDate.of(2025,5,15),Set.of(PC, vetement));

        double projectionFutureDeJohn = patrimoineDeJohn.projectionFuture(LocalDate.of(2031, 1, 1));
        System.out.println(projectionFutureDeJohn);

    }
}
