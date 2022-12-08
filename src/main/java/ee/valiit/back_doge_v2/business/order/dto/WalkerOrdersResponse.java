package ee.valiit.back_doge_v2.business.order.dto;

import ee.valiit.back_doge_v2.business.dog.dto.OrderedDog;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class WalkerOrdersResponse {
    private Integer orderId;
    private LocalDate walkingDate;
    private Integer timeFrom;
    private Integer timeTo;
    private String cityName;
    private String address;
    private List<OrderedDog> dogs;
}
