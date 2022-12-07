package ee.valiit.back_doge_v2.business.dog.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class WalkerSearchRequest {
    private Integer cityId;
    private LocalDate date;
    private Integer timeFrom;
    private Integer timeTo;
    List<DogInfo> dogInfos;
}
