package ee.valiit.back_doge_v2.domain.dog_information.breeds;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Breed} entity
 */
@Data
public class BreedDto implements Serializable {
    private final Integer breedId;
    @Size(max = 20)
    @NotNull
    private final String breedName;
}