package ee.valiit.back_doge_v2.domain.order_information.walking;

import ee.valiit.back_doge_v2.business.order.dto.WalkingRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WalkingMapper {

//    @Mapping(target = "city", ignore = true)
//    @Mapping(target = "walkerUser", ignore = true)
    @Mapping(constant = "A",target = "status")
    Walking toEntity(WalkingRequest request);
}
