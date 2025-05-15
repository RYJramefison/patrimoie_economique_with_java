package modele;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Argent {
    private final double montant;
    private final Devise devise;

}
