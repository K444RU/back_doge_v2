package ee.valiit.back_doge_v2.domain.order_information.order;

import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    // TODO: FIX mappings
    @Mapping(source = "walkingId", target = "walking.id")
    @Mapping(constant = "A", target = "status")
    @Mapping(target = "timeTo", ignore = true)
    @Mapping(target = "timeFrom", ignore = true)
    Order toEntity(OrderRequest request);

}
