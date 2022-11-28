package ee.valiit.back_doge_v2.domain.user_role_information.user;

import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactDto;
import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleDto;
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
    private Integer id;
    @NotNull
    private RoleDto roleId;
    @NotNull
    private ContactDto contactId;
    @Size(max = 50)
    @NotNull
    private String username;
    @Size(max = 50)
    @NotNull
    private String password;
}