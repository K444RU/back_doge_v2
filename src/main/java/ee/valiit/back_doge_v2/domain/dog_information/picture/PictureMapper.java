package ee.valiit.back_doge_v2.domain.dog_information.picture;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PictureMapper {
    Picture pictureDtoToPicture(PictureDto pictureDto);

    PictureDto pictureToPictureDto(Picture picture);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Picture updatePictureFromPictureDto(PictureDto pictureDto, @MappingTarget Picture picture);
}
