package ee.valiit.back_doge_v2.business.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link ee.valiit.back_doge_v2.domain.user_role_information.contact.Contact} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoUpdate implements Serializable {
    @Size(max = 30)
    @NotNull
    private String email;
    @Size(max = 30)
    @NotNull
    private String city;
    @Size(max = 50)
    @NotNull
    private String firstname;
    @Size(max = 50)
    @NotNull
    private String lastname;
    @Size(max = 300)
    private String additionalInformation;
}