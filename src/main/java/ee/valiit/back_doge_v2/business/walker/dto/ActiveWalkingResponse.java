package ee.valiit.back_doge_v2.business.walker.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActiveWalkingResponse {
    private Integer walkingId;
    private Integer userId;
    private String cityName;
    private LocalDate date;
    private Integer timeFrom;
    private Integer timeTo;

}
