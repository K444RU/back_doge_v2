package ee.valiit.back_doge_v2.domain.user_role_information.role;

import ee.valiit.back_doge_v2.user_profile.NewUserRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleMapper {

    @Mapping(source = "roleId", target = "id")
    Role saveNewUserRole(NewUserRequest request);


    List <RoleDto>  roleToRoleDto(List<Role> all);
}
