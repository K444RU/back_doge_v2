package ee.valiit.back_doge_v2.domain.dog_information.dog;

import ee.valiit.back_doge_v2.domain.dog_information.breeds.Breed;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserDto;
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
    private Integer id;
    @NotNull
    private User user;
    @NotNull
    private Breed breed;
    private Integer sizeId;
    @Size(max = 30)
    @NotNull
    private String sizeType;
    @NotNull
    private Integer sizePrice;
    @Size(max = 50)
    @NotNull
    private String name;
    @NotNull
    private Integer age;
    @Size(max = 300)
    private String additionalInformation;
    private byte[] dogPhoto;
    @Size(max = 1)
    @NotNull
    private String status;
}