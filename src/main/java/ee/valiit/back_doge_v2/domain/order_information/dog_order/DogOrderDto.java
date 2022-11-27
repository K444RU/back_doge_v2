package ee.valiit.back_doge_v2.domain.order_information.dog_order;

import ee.valiit.back_doge_v2.domain.order_information.order.OrderDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link DogOrder} entity
 */
@Data
public class DogOrderDto implements Serializable {
    private final Integer id;
    @NotNull
    private final DogDto dog;
    @NotNull
    private final OrderDto order;
}