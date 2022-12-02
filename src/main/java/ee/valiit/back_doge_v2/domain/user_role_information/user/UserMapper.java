package ee.valiit.back_doge_v2.domain.user_role_information.user;

import ee.valiit.back_doge_v2.business.login.dto.LoginResponse;
import ee.valiit.back_doge_v2.business.register.dto.NewUserRequest;
import ee.valiit.back_doge_v2.business.user.dto.UserHomepageInfoResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.id", target = "roleId")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "contact.firstname", target = "firstname")
    @Mapping(source = "contact.lastname", target = "lastname")
    @Mapping(source = "contact.additionalInformation", target = "additionalInformation")
    @Mapping(source = "contact.photoData", target = "userPhoto", qualifiedByName = "userPhotoByteToString")
    UserHomepageInfoResponse userToHomepageResponse(User byId);

    @Named("userPhotoByteToString")
    static String userPhotoByteToString(byte[] photoData) {
        if (photoData == null) {
            return null;
        }
            String picture = new String(photoData);
            return picture;
    }

    User newUserRequestToUser(NewUserRequest request);

//    @Mapping(source = "userId", target = "id")
//    @Mapping(source = "photoData", target = "contact.photoData", qualifiedByName = "stringPhotoToBYteArray")
//    User userPhotoRequestToContact(OwnerPictureRequest request);
}
