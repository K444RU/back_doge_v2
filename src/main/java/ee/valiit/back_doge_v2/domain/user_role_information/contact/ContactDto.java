package ee.valiit.back_doge_v2.domain.user_role_information.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Contact} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto implements Serializable {
    private Integer id;
    @Size(max = 30)
    @NotNull
    private String email;
    @Size(max = 30)
    @NotNull
    private String city;
    @Size(max = 30)
    @NotNull
    private String firstname;
    @Size(max = 30)
    @NotNull
    private String lastname;
    @Size(max = 200)
    private String additionalInformation;
    private byte[] photoData;
}