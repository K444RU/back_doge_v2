package ee.valiit.back_doge_v2.business.user.dtos;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class OwnerHomepageInfoResponse {
    private Integer userId;
    private String firstname;
    private String lastname;
    @Nullable
    private String additionalInformation;
    @Nullable
    private String userPhoto;
}
