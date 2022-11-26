package ee.valiit.back_doge_v2.domain.user_role_information.user;

import ee.valiit.back_doge_v2.domain.user_role_information.contact.Contact;
import ee.valiit.back_doge_v2.login.LoginResponse;
import ee.valiit.back_doge_v2.registration.NewUserRegistration;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.id", target = "roleId")
    @Mapping(source = "role.type", target = "roleType")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
//    @Mapping(source = "eMail", target = "eMail")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "additionalInformation", target = "additionalInformation")
    NewUserRegistration toNewUser(Contact contact);

    User toEntity(NewUserRegistration request);

}
