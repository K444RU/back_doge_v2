package ee.valiit.back_doge_v2.domain.order_information.order;

import ee.valiit.back_doge_v2.business.dog.dto.DogOrders;
import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import ee.valiit.back_doge_v2.business.order.dto.OrderStatusUpdate;
import ee.valiit.back_doge_v2.business.order.dto.WalkerOrdersResponse;
import org.mapstruct.*;

import java.time.LocalTime;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "walkingId", target = "walking.id")
    @Mapping(constant = "A", target = "status")
    @Mapping(target = "timeTo", ignore = true)
    @Mapping(target = "timeFrom", ignore = true)
    Order toEntity(OrderRequest request);


    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "walking.city.name", target = "cityName")
    @Mapping(source = "timeFrom", target = "timeFrom", qualifiedByName = "localTimeToInteger")
    @Mapping(source = "timeTo", target = "timeTo", qualifiedByName = "localTimeToInteger")
    WalkerOrdersResponse entityToOrdersResponse(Order response);
    List<WalkerOrdersResponse> entityToOrdersResponses(List<Order> responses);


    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "walking.user.contact.firstname", target = "walkerFirstname")
    @Mapping(source = "walking.user.contact.lastname", target = "walkerLastname")
    @Mapping(source = "walking.user.contact.additionalInformation", target = "walkerAdditionalInformation")
    @Mapping(source = "walking.user.contact.photoData", target = "walkerPhoto", qualifiedByName = "userPhotoByteToString")
    @Mapping(source = "walking.city.name", target = "cityName")
    @Mapping(source = "status", target = "orderStatus")
    @Mapping(source = "timeFrom", target = "timeFrom", qualifiedByName = "localTimeToInteger")
    @Mapping(source = "timeTo", target = "timeTo", qualifiedByName = "localTimeToInteger")
    DogOrders entityToOrderedDogsResponse(Order response);
    List<DogOrders> entityToOrderedDogsResponses(List<Order> responses);

    @Named("localTimeToInteger")
    static Integer localTimeToInteger(LocalTime time) {
        return time.getHour();
    }

    @Named("userPhotoByteToString")
    static String userPhotoByteToString(byte[] photoData) {
        if (photoData == null) {
            return null;
        }
        String picture = new String(photoData);
        return picture;
    }
    @Mapping(constant = "I", target = "status")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrderStatus(OrderStatusUpdate orderStatusUpdate, @MappingTarget Order order);
}

