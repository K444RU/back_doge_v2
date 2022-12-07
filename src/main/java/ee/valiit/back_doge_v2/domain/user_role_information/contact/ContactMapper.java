package ee.valiit.back_doge_v2.domain.user_role_information.contact;

import ee.valiit.back_doge_v2.business.register.dto.NewUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {

    Contact newUserRequestToContact(NewUserRequest request);

}
