package ee.valiit.back_doge_v2.domain.order_information.dog_order;

import ee.valiit.back_doge_v2.business.dog.dto.OrderedDog;
import ee.valiit.back_doge_v2.business.order.dto.WalkerActiveOrderResponse;
import org.mapstruct.*;

import java.time.LocalDate;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DogOrderMapper {

    @Mapping(source = "order.walkingDate", target = "walkingDate")
    @Mapping(source = "order.timeFrom", target = "timeFrom")
    @Mapping(source = "order.timeTo", target = "timeTo")
    @Mapping(source = "order.walking.city.name", target = "cityName")
    @Mapping(source = "order.address", target = "address")
    @Mapping(source = "dog.name", target = "dogs.dogName")
    WalkerActiveOrderResponse entityToOrdersResponse(DogOrder order);
    List<WalkerActiveOrderResponse> entityToOrdersResponses(List<DogOrder> orders);
}
//
//    private LocalDate walkingDate;
//    private Integer timeFrom;
//    private Integer timeTo;
//    private String cityName;
//    private String address;
//    private List<OrderedDog> dogs;