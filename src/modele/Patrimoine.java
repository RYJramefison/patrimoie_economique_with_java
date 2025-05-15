package modele;

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

        return 0;
    }
}
