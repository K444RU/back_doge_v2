package ee.valiit.back_doge_v2.domain.order_information.walking;

import ee.valiit.back_doge_v2.domain.order_information.city.CityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A DTO for the {@link Walking} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalkingDto implements Serializable {
    private Integer id;
    @NotNull
    private UserDto walkerUserId;
    @NotNull
    private CityDto cityId;
    @NotNull
    private LocalDate dateFrom;
    @NotNull
    private LocalDate dateTo;
    @NotNull
    private LocalTime timeFrom;
    @NotNull
    private LocalTime timeTo;
}