package ee.valiit.back_doge_v2.business.dog.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class WalkerSearchRequest {
    private Integer cityId;
    private LocalDate walkingDate;
    private LocalTime timeFrom;
    private LocalTime timeTo;
//    List<DogInfo> dogInfos;
}
