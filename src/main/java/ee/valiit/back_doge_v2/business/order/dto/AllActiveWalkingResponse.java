package ee.valiit.back_doge_v2.business.order.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AllActiveWalkingResponse {
    private Integer walkingId;
    private String walkerName;
    private LocalDate date;
    private Integer timeFrom;
    private Integer timeTo;
}
