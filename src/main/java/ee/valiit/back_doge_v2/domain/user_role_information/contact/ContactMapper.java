package ee.valiit.back_doge_v2.domain.user_role_information.contact;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    Contact contactDto1ToContact(ContactDto contactDto1);

    ContactDto contactToContactDto1(Contact contact);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Contact updateContactFromContactDto1(ContactDto contactDto1, @MappingTarget Contact contact);
}
