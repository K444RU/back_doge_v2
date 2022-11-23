package ee.valiit.back_doge_v2.domain.dog_information.breed;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BreedMapper {
    Breed breedDtoToBreed(BreedDto breedDto);

    List<BreedDto> breedToBreedDto(List<Breed> breed);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Breed updateBreedFromBreedDto(BreedDto breedDto, @MappingTarget Breed breed);
}
