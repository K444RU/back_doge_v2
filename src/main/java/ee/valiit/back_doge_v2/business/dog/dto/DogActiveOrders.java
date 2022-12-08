package ee.valiit.back_doge_v2.business.dog.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DogActiveOrders {
    private Integer orderId;
    private String walkerFirstname;
    private String walkerLastname;
    private String walkerAdditionalInformation;
    private String walkerPhoto;
    private LocalDate walkingDate;
    private Integer timeFrom;
    private Integer timeTo;
    private String cityName;
    private String address;
    private Boolean orderStatus;

}
