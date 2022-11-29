package ee.valiit.back_doge_v2.business.dog_profile;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class DogRegistrationRequest {
    private Integer userId;
    private Integer dogSizeId;
    private Integer dogBreedId;
    private String dogName;
    private Integer dogAge;
    @Nullable
    private String dogAdditionalInformation;
    @Nullable
    private String dogPhoto;


}
