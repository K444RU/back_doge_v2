package ee.valiit.back_doge_v2.domain.dog_information.size;

import ee.valiit.back_doge_v2.business.dog.dto.DogSizeDto;
import ee.valiit.back_doge_v2.business.dog.dto.WalkingSizeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SizeMapper {

    @Mapping(source = "id", target = "sizeId")
    @Mapping(source = "type", target = "sizeType")
    @Mapping(constant = "false", target = "isSelected")
    DogSizeDto toDto(Size size);

    List<DogSizeDto> sizeToSizeDto(List<Size> size);

    @Mapping(source = "type", target = "sizeType")
    WalkingSizeDto fromEntityToWalkingSizeDto(Size sizeTypeByWalkingId);

    List<WalkingSizeDto> fromEntityToWalkingSizeDtos(List<Size> sizeTypeByWalkingIds);
}
