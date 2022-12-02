package ee.valiit.back_doge_v2.domain.order_information.city;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {


    City cityDtoToCity(CityDto cityDto);
    @Mapping(source = "id", target = "cityId")
    @Mapping(source = "name", target = "cityName")
    CityDto cityToCityDto(City city);
    List<CityDto> cityToCityDto(List<City>city);

}
