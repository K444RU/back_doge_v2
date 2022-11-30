package ee.valiit.back_doge_v2.business.user.dtos;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;

@Data
public class OwnerHomepageResponse {
    private String firstname;
    private String lastname;
    private String additionalInformation;
    @Nullable
    private String userPhoto;
}
