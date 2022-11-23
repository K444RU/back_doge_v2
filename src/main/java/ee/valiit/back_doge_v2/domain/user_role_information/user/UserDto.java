package ee.valiit.back_doge_v2.domain.user_role_information.user;

import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactDto;
import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Integer id;
    @NotNull
    private final RoleDto role;
    @NotNull
    private final ContactDto contact;
    @Size(max = 20)
    @NotNull
    private final String username;
    @NotNull
    private final Integer password;
}