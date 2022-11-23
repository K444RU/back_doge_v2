package ee.valiit.back_doge_v2.domain.dog_information.dog;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DogMapper {
    Dog dogDtoToDog(DogDto dogDto);

    DogDto dogToDogDto(Dog dog);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Dog updateDogFromDogDto(DogDto dogDto, @MappingTarget Dog dog);
}
