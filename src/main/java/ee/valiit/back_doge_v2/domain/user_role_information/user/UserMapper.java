package ee.valiit.back_doge_v2.domain.user_role_information.user;

import ee.valiit.back_doge_v2.login.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source
            = "id", target = "userId")
    @Mapping(source = "role.id", target = "roleId")
    @Mapping(source = "role.type", target = "roleType")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "roleId", target = "role.id")
    @Mapping(source = "contactId", target = "contact.id")
    User userDtoToUser(UserDto userDto);


}
