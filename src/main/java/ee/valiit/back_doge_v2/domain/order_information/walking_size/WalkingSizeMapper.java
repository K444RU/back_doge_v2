package ee.valiit.back_doge_v2.domain.order_information.walking_size;

import ee.valiit.back_doge_v2.business.login.dto.SizeDtoToWalkingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WalkingSizeMapper {

    @Mapping(source = "size.id", target = "sizeId")
    SizeDtoToWalkingResponse fromEntityToSizeDtoToWalkingResponse(WalkingSize sizeTypeByWalkingId);
}
