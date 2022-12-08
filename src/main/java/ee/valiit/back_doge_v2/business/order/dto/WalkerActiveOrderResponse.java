package ee.valiit.back_doge_v2.business.order.dto;

import ee.valiit.back_doge_v2.business.dog.dto.OrderedDog;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class WalkerActiveOrderResponse {
    private LocalDate walkingDate;
    private LocalTime timeFrom;
    private LocalTime timeTo;
    private String cityName;
    private String address;
    private List<OrderedDog> dogs;
}
