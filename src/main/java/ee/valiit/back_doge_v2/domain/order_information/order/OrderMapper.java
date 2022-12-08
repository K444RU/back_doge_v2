package ee.valiit.back_doge_v2.domain.order_information.order;

import ee.valiit.back_doge_v2.business.dog.dto.OrderedDog;
import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkerActiveOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    // TODO: FIX mappings
    @Mapping(source = "walkingId", target = "walking.id")
    @Mapping(constant = "A", target = "status")
    @Mapping(target = "timeTo", ignore = true)
    @Mapping(target = "timeFrom", ignore = true)
    Order toEntity(OrderRequest request);


    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "walking.city.name", target = "cityName")
    @Mapping(source = "timeFrom", target = "timeFrom", qualifiedByName = "localTimeToInteger")
    @Mapping(source = "timeTo", target = "timeTo", qualifiedByName = "localTimeToInteger")
    WalkerActiveOrderResponse entityToOrdersResponse(Order response);

    @Named("localTimeToInteger")
    static Integer localTimeToInteger(LocalTime time) {
        return time.getHour();
    }

    List<WalkerActiveOrderResponse> entityToOrdersResponses(List<Order> responses);
}
