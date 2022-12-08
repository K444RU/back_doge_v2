package ee.valiit.back_doge_v2.domain.order_information.walking;

import ee.valiit.back_doge_v2.business.walker.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.walker.dto.WalkingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WalkingMapper {


    // TODO: FIX mappings
    @Mapping(constant = "A", target = "status")
//    @Mapping(target = "timeTo", ignore = true)
//    @Mapping(target = "timeFrom", ignore = true)
    Walking toEntity(WalkingRequest request);

    @Mapping(source = "id", target = "walkingId")
    @Mapping(source = "city.name", target = "cityName")
//    @Mapping(target = "timeTo", ignore = true)
//    @Mapping(target = "timeFrom", ignore = true)
    WalkingResponse fromEntityToResponse(Walking byUserId);

    List<WalkingResponse> fromEntityToResponses(List<Walking> byUserIds);
}
