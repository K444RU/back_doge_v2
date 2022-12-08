package ee.valiit.back_doge_v2.business.walker.dto;

import ee.valiit.back_doge_v2.business.dog.dto.WalkingSizeDto;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class WalkingResponse {
    private Integer walkingId;
    private String cityName;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private LocalTime timeFrom;
    private LocalTime timeTo;
    private List<WalkingSizeDto> sizeTypes;
}