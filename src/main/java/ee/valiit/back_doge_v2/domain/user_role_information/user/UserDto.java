package ee.valiit.back_doge_v2.domain.user_role_information.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    @Size(max = 20)
    @NotNull
    private String username;
    @Size(max = 20)
    @NotNull
    private String password;
    @Size(max = 20)
    @NotNull
    private Integer roleId;
    @Size(max = 20)
    @NotNull
    private Integer contactId;
}