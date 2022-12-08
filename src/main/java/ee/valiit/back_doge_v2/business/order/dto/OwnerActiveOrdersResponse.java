package ee.valiit.back_doge_v2.business.order.dto;

import ee.valiit.back_doge_v2.business.dog.dto.DogActiveOrders;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OwnerActiveOrdersResponse {
    private Integer dogId;
    private String dogName;
    List<DogActiveOrders> orders;

}
