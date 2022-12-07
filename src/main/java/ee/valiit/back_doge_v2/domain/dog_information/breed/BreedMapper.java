package ee.valiit.back_doge_v2.domain.dog_information.breed;

import ee.valiit.back_doge_v2.business.dog.dto.DogBreedDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BreedMapper {

    @Mapping(source = "id", target = "breedId")
    @Mapping(source = "name", target = "breedName")
    DogBreedDto toDto(Breed breed);

    List<DogBreedDto> breedToBreedDto(List<Breed> breed);
}
