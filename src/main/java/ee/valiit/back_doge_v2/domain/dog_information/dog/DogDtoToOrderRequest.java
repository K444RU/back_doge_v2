package ee.valiit.back_doge_v2.domain.dog_information.dog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Dog} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogDtoToOrderRequest implements Serializable {
    private Integer dogId;
    private Boolean isSelected;

}

