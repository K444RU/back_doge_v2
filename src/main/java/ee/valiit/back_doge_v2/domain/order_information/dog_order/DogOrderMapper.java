package ee.valiit.back_doge_v2.domain.order_information.dog_order;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DogOrderMapper {
    DogOrder dogOrderDtoToDogOrder(DogOrderDto dogOrderDto);

    DogOrderDto dogOrderToDogOrderDto(DogOrder dogOrder);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DogOrder updateDogOrderFromDogOrderDto(DogOrderDto dogOrderDto, @MappingTarget DogOrder dogOrder);
}
