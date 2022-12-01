package ee.valiit.back_doge_v2.business.user.dtos;


import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class OwnerHomePageDogInfoResponse {
    @Nullable
    private String dogPhoto;
    private String dogName;
    private String dogBreed;
    private String dogAge;
    private String dogSizeType;
    @Nullable
    private String dogAdditionalInformation;

}
