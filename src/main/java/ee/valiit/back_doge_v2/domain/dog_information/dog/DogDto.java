package ee.valiit.back_doge_v2.domain.dog_information.dog;

import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Dog} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogDto implements Serializable {
    private Integer dogId;
    @NotNull
    private UserDto ownerUserId;
    @NotNull
    private BreedDto breedId;
    @NotNull
    private SizeDto sizeId;
    @Size(max = 50)
    @NotNull
    private String dogName;
    @NotNull
    private Integer dogAge;
    @Size(max = 300)
    private String dogAdditionalInformation;
    private byte[] dogPhotoData;
}