package ee.valiit.back_doge_v2.domain.order_information.walking_size;

import ee.valiit.back_doge_v2.domain.dog_information.size.SizeDto;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link WalkingSize} entity
 */
@Data
public class WalkingSizeDto implements Serializable {

    @NotNull
    private String sizeType;
}