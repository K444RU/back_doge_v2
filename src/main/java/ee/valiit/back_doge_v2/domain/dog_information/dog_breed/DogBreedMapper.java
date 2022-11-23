package ee.valiit.back_doge_v2.domain.dog_information.dog_breed;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DogBreedMapper {
    DogBreed dogBreedDtoToDogBreed(DogBreedDto dogBreedDto);

    DogBreedDto dogBreedToDogBreedDto(DogBreed dogBreed);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DogBreed updateDogBreedFromDogBreedDto(DogBreedDto dogBreedDto, @MappingTarget DogBreed dogBreed);
}
