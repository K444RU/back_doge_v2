package ee.valiit.back_doge_v2.domain.order_information.walking;

import ee.valiit.back_doge_v2.business.order.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkingResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WalkingMapper {

//    @Mapping(target = "city", ignore = true)
//    @Mapping(target = "walkerUser", ignore = true)
    @Mapping(constant = "A",target = "status")
    Walking toEntity(WalkingRequest request);

    @Mapping(source = "id", target = "walkingId")
    @Mapping(source = "city.name", target = "cityName")
    WalkingResponse fromEntityToResponse(Walking byUserId);
    List<WalkingResponse> fromEntityToResponses(List<Walking> byUserIds);
}
