package ee.valiit.back_doge_v2.domain.order_information.order;

import ee.valiit.back_doge_v2.business.dog.dto.DogActiveOrders;
import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import ee.valiit.back_doge_v2.business.order.dto.OwnerActiveOrdersResponse;
import ee.valiit.back_doge_v2.business.order.dto.WalkerActiveOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

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
    WalkerActiveOrderResponse entityToOrdersResponse(Order response);
    List<WalkerActiveOrderResponse> entityToOrdersResponses(List<Order> responses);


    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "walking.user.contact.firstname", target = "walkerFirstname")
    @Mapping(source = "walking.user.contact.lastname", target = "walkerLastname")
    @Mapping(source = "walking.user.contact.additionalInformation", target = "walkerAdditionalInformation")
    @Mapping(source = "walking.user.contact.photoData", target = "walkerPhoto", qualifiedByName = "userPhotoByteToString")
    @Mapping(source = "walking.city.name", target = "cityName")
    @Mapping(source = "status", target = "orderStatus")
    @Mapping(source = "timeFrom", target = "timeFrom", qualifiedByName = "localTimeToInteger")
    @Mapping(source = "timeTo", target = "timeTo", qualifiedByName = "localTimeToInteger")
    DogActiveOrders entityToOrderedDogsResponse(Order response);
    List<DogActiveOrders> entityToOrderedDogsResponses(List<Order> responses);

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
}

