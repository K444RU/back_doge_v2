package ee.valiit.back_doge_v2.business.order.dto;

import lombok.Data;

@Data
public class WalkingRequest {
    private Integer cityId;
    private String dateFrom;
    private String dateTo;
    private Integer timeFrom;
    private Integer timeTo;

}
