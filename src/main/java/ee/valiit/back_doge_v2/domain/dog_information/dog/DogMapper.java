package ee.valiit.back_doge_v2.domain.dog_information.dog;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DogMapper {
    @Mapping(source = "ownerUser", target = "ownerUser.id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "additionalInformation", target = "additionalInformation")
    Dog dogDtoToDog(DogDto dogDto);

    DogDto dogToDogDto(Dog dog);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Dog updateDogFromDogDto(DogDto dogDto, @MappingTarget Dog dog);
}
