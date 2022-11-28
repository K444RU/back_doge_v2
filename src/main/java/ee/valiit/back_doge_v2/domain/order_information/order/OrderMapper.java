package ee.valiit.back_doge_v2.domain.order_information.order;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "orderId", target = "id")
    @Mapping(source = "walkingId", target = "walking")
    Order orderDtoToOrder(OrderDto orderDto);

    @InheritInverseConfiguration(name = "orderDtoToOrder")
    OrderDto orderToOrderDto(Order order);

    @InheritConfiguration(name = "orderDtoToOrder")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order updateOrderFromOrderDto(OrderDto orderDto, @MappingTarget Order order);
}
