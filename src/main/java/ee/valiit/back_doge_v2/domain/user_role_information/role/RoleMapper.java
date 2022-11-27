package ee.valiit.back_doge_v2.domain.user_role_information.role;

import ee.valiit.back_doge_v2.registration.NewUserRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleMapper {
    Role roleDtoToRole(RoleDto roleDto);

    RoleDto roleToRoleDto(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role updateRoleFromRoleDto(RoleDto roleDto, @MappingTarget Role role);


    @Mapping(source = "role", target = "type")
    Role saveNewUserRole(NewUserRequest request);
}
