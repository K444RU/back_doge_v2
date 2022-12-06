package ee.valiit.back_doge_v2.domain.dog_information.size;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link Size} entity
 */
@Data
public class SizeDto implements Serializable {
    private Integer sizeId;
//    @javax.validation.constraints.Size(max = 30)
//    @NotNull
//    private String sizeType;
//    @NotNull
//    private Integer sizePrice;
    private Boolean isSelected;
}