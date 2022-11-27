package ee.valiit.back_doge_v2.domain.dog_information.dog;

import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
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
    @NotNull
    private User ownerUser;
    @Size(max = 30)
    @NotNull
    private String name;
    @NotNull
    private Integer age;
    @Size(max = 300)
    private String additionalInformation;
}