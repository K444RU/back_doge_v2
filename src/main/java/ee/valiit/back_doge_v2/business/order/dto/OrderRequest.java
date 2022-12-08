package ee.valiit.back_doge_v2.business.order.dto;

import ee.valiit.back_doge_v2.business.dog.dto.DogDtoToOrderRequest;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderRequest {
    private Integer walkingId;
    private LocalDate walkingDate;
    private Integer timeFrom;
    private Integer timeTo;
    private String address;
    private List<DogDtoToOrderRequest> dogs;
}
