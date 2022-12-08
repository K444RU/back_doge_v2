package ee.valiit.back_doge_v2.business.dog.dto;


import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OwnerHomePageDogInfoResponse {
    private Integer dogId;
    @Nullable
    private String dogPhoto;
    private String dogName;
    private String dogBreed;
    private String dogAge;
    private String dogSizeType;
    @Nullable
    private String dogAdditionalInformation;
    @NotNull
    private String status;


}
