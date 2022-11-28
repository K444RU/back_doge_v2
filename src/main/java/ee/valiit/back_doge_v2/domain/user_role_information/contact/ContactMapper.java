package ee.valiit.back_doge_v2.domain.user_role_information.contact;

import ee.valiit.back_doge_v2.login.register.NewUserRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    Contact contactDtoToContact(ContactDto contactDto);

    ContactDto contactToContactDto(Contact contact);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Contact updateContactFromContactDto(ContactDto contactDto, @MappingTarget Contact contact);

    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "additionalInformation", target = "additionalInformation")
    Contact newUserRequestToContact(NewUserRequest request);
}
