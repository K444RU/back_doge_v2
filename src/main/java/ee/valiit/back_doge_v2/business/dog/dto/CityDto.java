package ee.valiit.back_doge_v2.business.dog.dto;

import ee.valiit.back_doge_v2.domain.order_information.city.City;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link City} entity
 */
@Data
public class CityDto implements Serializable {
    private final Integer cityId;
    @Size(max = 255)
    @NotNull
    private final String cityName;
}