package ee.valiit.back_doge_v2.domain.order_information.price;

import ee.valiit.back_doge_v2.domain.walker_information.size.SizeDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link Price} entity
 */
@Data
public class PriceDto implements Serializable {
    private final Integer id;
    @NotNull
    private final SizeDto size;
    @NotNull
    private final Integer hour;
}