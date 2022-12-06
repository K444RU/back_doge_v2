package ee.valiit.back_doge_v2.business.order.dto;

import ee.valiit.back_doge_v2.domain.dog_information.size.SizeDto;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeDtoToWalkingResponse;
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
    private List<SizeDto> size;

}
