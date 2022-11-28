package ee.valiit.back_doge_v2.domain.dog_information.dog_picture;

import ee.valiit.back_doge_v2.domain.dog_information.dog.DogDto;
import ee.valiit.back_doge_v2.domain.dog_information.picture.PictureDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link DogPicture} entity
 */
@Data
public class DogPictureDto implements Serializable {
    private final Integer id;
    @NotNull
    private final DogDto dog;
    @NotNull
    private final PictureDto picture;
}