package ee.valiit.back_doge_v2.user_profile;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class NewUserRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String city;
    private String username;
    private String password;
    private String role;
    @Nullable
    private String additionalInformation;

}
