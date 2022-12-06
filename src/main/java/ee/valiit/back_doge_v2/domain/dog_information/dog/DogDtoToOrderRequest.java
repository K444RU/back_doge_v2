package ee.valiit.back_doge_v2.domain.dog_information.dog;

import lombok.Data;

@Data
public class DogDtoToOrderRequest {

    private Integer dogId;
    private Boolean isSelected;
}
