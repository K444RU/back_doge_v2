package ee.valiit.back_doge_v2.domain.walker_information.walking;

import ee.valiit.back_doge_v2.domain.order_information.order.city.CityDto;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A DTO for the {@link Walking} entity
 */
@Data
public class WalkingDto implements Serializable {
    private final Integer id;
    @NotNull
    private final UserDto walkerUser;
    @NotNull
    private final CityDto city;
    @NotNull
    private final LocalDate dateFrom;
    @NotNull
    private final LocalDate dateTo;
    @NotNull
    private final LocalTime timeFrom;
    @NotNull
    private final LocalTime timeTo;
}