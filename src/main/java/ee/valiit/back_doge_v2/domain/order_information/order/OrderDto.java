package ee.valiit.back_doge_v2.domain.order_information.order;

import ee.valiit.back_doge_v2.domain.walker_information.walking.WalkingDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A DTO for the {@link Order} entity
 */
@Data
public class OrderDto implements Serializable {
    private final Integer id;
    @NotNull
    private final WalkingDto walking;
    @NotNull
    private final LocalDate walkingDate;
    @NotNull
    private final LocalTime timeFrom;
    @NotNull
    private final LocalTime timeTo;
    @NotNull
    private final Integer address;
    @NotNull
    private final Integer totalPrice;
}