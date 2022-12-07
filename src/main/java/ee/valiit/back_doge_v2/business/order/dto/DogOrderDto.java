package ee.valiit.back_doge_v2.business.order.dto;

import ee.valiit.back_doge_v2.business.dog.dto.DogDto;
import ee.valiit.back_doge_v2.domain.order_information.dog_order.DogOrder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link DogOrder} entity
 */
@Data
public class DogOrderDto implements Serializable {
    private final Integer dogOrderId;
    @NotNull
    private final DogDto dogId;
    @NotNull
    private final OrderDto orderId;
}