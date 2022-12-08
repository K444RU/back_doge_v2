package ee.valiit.back_doge_v2.business.order.dto;

import ee.valiit.back_doge_v2.business.dog.dto.DogOrders;
import lombok.Data;

import java.util.List;

@Data
public class OwnerOrdersResponse {
    private Integer dogId;
    private String dogName;
    List<DogOrders> orders;

}
