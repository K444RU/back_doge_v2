package ee.valiit.back_doge_v2.business.order.dto;

import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSizeDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class WalkingResponse {
    private Integer walkingId;
    private String cityName;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Integer timeFrom;
    private Integer timeTo;
    private List<WalkingSizeDto> sizeType;
}
