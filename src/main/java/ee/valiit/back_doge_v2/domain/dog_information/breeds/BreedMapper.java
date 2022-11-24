package ee.valiit.back_doge_v2.domain.dog_information.breeds;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BreedMapper {
    Breed breedDtoToBreed(BreedDto breedDto);

    BreedDto breedToBreedDto(Breed breed);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Breed updateBreedFromBreedDto(BreedDto breedDto, @MappingTarget Breed breed);
}
