package ee.valiit.back_doge_v2.business.login.dto;

import ee.valiit.back_doge_v2.domain.user_role_information.role.Role;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Role} entity
 */
@Data
public class RoleDto implements Serializable {
    private final Integer roleId;
    @Size(max = 20)
    @NotNull
    private final String roleType;
}
