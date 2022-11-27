package ee.valiit.back_doge_v2.domain.dog_information.dog_breed;

import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link DogBreed} entity
 */
@Data
public class DogBreedDto implements Serializable {
    private final Integer id;
    @NotNull
    private final DogDto dog;
    @NotNull
    private final BreedDto breed;
}