package ee.valiit.back_doge_v2.business.dog.dto;

import ee.valiit.back_doge_v2.domain.order_information.city.City;
import ee.valiit.back_doge_v2.domain.order_information.walking.Walking;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Walking} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalkingDto implements Serializable {
    private Integer id;
    @NotNull
    private User user;
    @NotNull
    private City city;
    @NotNull
    private LocalDate dateFrom;
    @NotNull
    private LocalDate dateTo;
    @NotNull
    private Integer timeFrom;
    @NotNull
    private Integer timeTo;
    @Size(max = 1)
    @NotNull
    private String status;
}