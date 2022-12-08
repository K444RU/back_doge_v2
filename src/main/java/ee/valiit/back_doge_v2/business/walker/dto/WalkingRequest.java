package ee.valiit.back_doge_v2.business.walker.dto;

import ee.valiit.back_doge_v2.business.form.dto.DogSizeDto;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class WalkingRequest {
    private Integer userId;
    private Integer cityId;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private LocalTime timeFrom;
    private LocalTime timeTo;
    private List<DogSizeDto> sizes;
}
