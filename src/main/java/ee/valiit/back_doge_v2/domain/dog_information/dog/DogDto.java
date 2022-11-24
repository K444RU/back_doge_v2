package ee.valiit.back_doge_v2.domain.dog_information.dog;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Dog} entity
 */
@Data
public class DogDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 30)
    @NotNull
    private final String name;
    @NotNull
    private final Integer age;
    @Size(max = 300)
    private final String adittionalInformation;
}