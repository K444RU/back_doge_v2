package ee.valiit.back_doge_v2.domain.user_role_information.role;

import ee.valiit.back_doge_v2.business.login.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleMapper {

    @Mapping(source = "id", target = "roleId")
    @Mapping(source = "type", target = "roleType")
    RoleDto toDto(Role role);

    List<RoleDto> roleListToDtos(List<Role> all);

}
