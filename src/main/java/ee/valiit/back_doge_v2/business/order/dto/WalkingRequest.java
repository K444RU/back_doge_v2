package ee.valiit.back_doge_v2.business.order.dto;

import ee.valiit.back_doge_v2.business.dog.dto.DogSizeDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class WalkingRequest {
    private Integer userId;
    private Integer cityId;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Integer timeFrom;
    private Integer timeTo;
    private List<DogSizeDto> sizes;

}
