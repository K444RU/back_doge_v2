package ee.valiit.back_doge_v2.domain.order_information.order;

import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A DTO for the {@link Order} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Serializable {
    private Integer orderId;
    @NotNull
    private WalkingDto walkingId;
    @NotNull
    private LocalDate walkingDate;
    @NotNull
    private LocalTime timeFrom;
    @NotNull
    private LocalTime timeTo;
    @Size(max = 255)
    @NotNull
    private String address;
    @NotNull
    private Integer totalPrice;
}