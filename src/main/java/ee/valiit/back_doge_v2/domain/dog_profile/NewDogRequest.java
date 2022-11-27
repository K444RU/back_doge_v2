package ee.valiit.back_doge_v2.domain.dog_profile;

import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
public class NewDogRequest {
    private Integer ownerUserId;
//    private String breed;
//    @Nullable
//    private String secondBreed;
    private String dogName;
    private Integer dogAge;
//    private String dogSize;
    @Nullable
    private String dogAdditionalInformation;
//    private byte dogPhoto;

}
