package ee.valiit.back_doge_v2.business.walker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class AllActiveWalkingResponse {
    private Integer walkingId;
    private String walkerName;
    private LocalDate date;
    private LocalTime timeFrom;
    private LocalTime timeTo;
}
