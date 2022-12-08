package ee.valiit.back_doge_v2.business.order.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class OrderStatusUpdate {
    private Integer orderId;
    @Size(max = 1)
    @NotNull
    private String orderStatus;
}
