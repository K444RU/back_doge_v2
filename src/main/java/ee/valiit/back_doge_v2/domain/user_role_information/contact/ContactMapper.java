package ee.valiit.back_doge_v2.domain.user_role_information.contact;

import ee.valiit.back_doge_v2.business.register.dto.NewUserRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    Contact contactDtoToContact(ContactDto contactDto);

    @Mapping(source = "id", target = "contactId")
    ContactDto contactToContactDto(Contact contact);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Contact updateContactFromContactDto(ContactDto contactDto, @MappingTarget Contact contact);


    Contact newUserRequestToContact(NewUserRequest request);
}
