package ee.valiit.back_doge_v2.dog_profile;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class DogRequest {
    private Integer ownerUserId;
    private Integer dogSizeId;
//    private String breed;
//    @Nullable
//    private String secondBreed;
    private String dogName;
    private Integer dogAge;

    @Nullable
    private String dogAdditionalInformation;
//    private byte dogPhoto;

}
