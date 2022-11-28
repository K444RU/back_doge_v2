package ee.valiit.back_doge_v2.domain.dog_information.breeds;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BreedMapper {

    List<BreedDto> breedToBreedDto(List<Breed> breed);
}
