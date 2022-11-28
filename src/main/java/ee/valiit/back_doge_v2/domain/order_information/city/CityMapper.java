package ee.valiit.back_doge_v2.domain.order_information.city;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {
    City cityDtoToCity(CityDto cityDto);

    CityDto cityToCityDto(City city);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City updateCityFromCityDto(CityDto cityDto, @MappingTarget City city);
}
