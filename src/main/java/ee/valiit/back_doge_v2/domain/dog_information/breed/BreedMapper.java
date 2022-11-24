package ee.valiit.back_doge_v2.domain.dog_information.breed;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BreedMapper {
    @Mapping(source = "breedId", target = "id")
    @Mapping(source = "breedName", target = "name")
    Breed breedDtoToBreed(BreedDto breedDto);

    @InheritInverseConfiguration(name = "breedDtoToBreed")
    BreedDto breedToBreedDto(Breed breed);

    @InheritConfiguration(name = "breedDtoToBreed")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Breed updateBreedFromBreedDto(BreedDto breedDto, @MappingTarget Breed breed);
}
