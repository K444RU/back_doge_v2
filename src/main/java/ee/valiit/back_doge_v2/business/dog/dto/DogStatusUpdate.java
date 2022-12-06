package ee.valiit.back_doge_v2.business.dog.dto;

import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
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
public class  DogStatusUpdate implements Serializable {
    @Size(max = 1)
    @NotNull
    private String dogStatus;
}