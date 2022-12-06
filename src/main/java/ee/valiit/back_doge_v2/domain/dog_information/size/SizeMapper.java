package ee.valiit.back_doge_v2.domain.dog_information.size;

import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSizeDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SizeMapper {



    @Mapping(source = "id", target = "sizeId")
    SizeDto toDto(Size size);
    List<SizeDto> sizeToSizeDto(List<Size> size);
    @Mapping(source = "type", target = "sizeType")
    WalkingSizeDto fromEntityToWalkingSizeDto(Size sizeTypeByWalkingId);
    List<WalkingSizeDto> fromEntityToWalkingSizeDtos(List<Size> sizeTypeByWalkingIds);
}
