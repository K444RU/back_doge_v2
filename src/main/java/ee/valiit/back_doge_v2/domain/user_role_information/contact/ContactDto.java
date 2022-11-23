package ee.valiit.back_doge_v2.domain.user_role_information.contact;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Contact} entity
 */
@Data
public class ContactDto implements Serializable {
    private final Integer id;
    @Size(max = 30)
    @NotNull
    private final String eMail;
    @Size(max = 30)
    @NotNull
    private final String city;
    @Size(max = 30)
    @NotNull
    private final String firstname;
    @Size(max = 30)
    @NotNull
    private final String lastname;
    @Size(max = 200)
    private final String adittionInformation;
    private final byte[] photoData;
}