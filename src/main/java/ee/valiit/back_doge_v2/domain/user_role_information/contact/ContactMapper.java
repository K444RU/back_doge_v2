package ee.valiit.back_doge_v2.domain.user_role_information.contact;

import ee.valiit.back_doge_v2.business.register.dto.NewUserRequest;
import ee.valiit.back_doge_v2.business.user.dto.UserInfoUpdate;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    Contact contactDtoToContact(ContactDto contactDto);

    @Mapping(source = "id", target = "contactId")
    ContactDto contactToContactDto(Contact contact);



    Contact newUserRequestToContact(NewUserRequest request);
}
