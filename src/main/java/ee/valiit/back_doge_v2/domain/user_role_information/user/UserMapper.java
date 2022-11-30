package ee.valiit.back_doge_v2.domain.user_role_information.user;

import ee.valiit.back_doge_v2.business.register.dtos.DogRegistrationRequest;
import ee.valiit.back_doge_v2.business.login.LoginResponse;
import ee.valiit.back_doge_v2.business.register.dtos.NewUserRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.id", target = "roleId")
    LoginResponse toLoginResponse(User user);


    @Mapping(source = "userId", target = "id")
    User getUser(DogRegistrationRequest request);


    User newUserRequestToUser(NewUserRequest request);
}
