package ee.valiit.back_doge_v2.domain.dog_information.dog_picture;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DogPictureMapper {
    DogPicture dogPictureDtoToDogPicture(DogPictureDto dogPictureDto);

    DogPictureDto dogPictureToDogPictureDto(DogPicture dogPicture);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DogPicture updateDogPictureFromDogPictureDto(DogPictureDto dogPictureDto, @MappingTarget DogPicture dogPicture);
}
