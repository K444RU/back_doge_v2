package ee.valiit.back_doge_v2.business.order.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderRequest {
    private Integer walkingId;
    private LocalDate walkingDate;
    private Integer timeFrom;
    private Integer timeTo;
    private String address;
    private Integer totalPrice;
}
