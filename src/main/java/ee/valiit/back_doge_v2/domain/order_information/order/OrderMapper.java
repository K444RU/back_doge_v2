package ee.valiit.back_doge_v2.domain.order_information.order;

import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {
//    Order toEntity(OrderRequest request);


//@Mapping(constant = "A", target = "status")
//    Order toEntity(OrderRequest request);

}
