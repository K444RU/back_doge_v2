package ee.valiit.back_doge_v2.domain.user_role_information.role;

import ee.valiit.back_doge_v2.business.register.dtos.NewUserRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleMapper {

    @Mapping(source = "roleId", target = "id")
    Role saveNewUserRole(NewUserRequest request);

    @Mapping(source = "id", target = "roleId")
    @Mapping(source = "type", target = "roleType")
    RoleDto toDto(Role role);
    List <RoleDto> roleListToDtos(List<Role> all);


}
