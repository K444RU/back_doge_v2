package ee.valiit.back_doge_v2.business.register.dtos;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class DogRegistrationRequest {
    private Integer userId;
    private Integer sizeId;
    private Integer breedId;
    private String dogName;
    private Integer dogAge;
    @Nullable
    private String dogAdditionalInformation;
    @Nullable
    private String dogPhoto;


}
