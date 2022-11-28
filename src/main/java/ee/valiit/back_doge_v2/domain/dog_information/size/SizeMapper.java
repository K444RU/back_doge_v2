package ee.valiit.back_doge_v2.domain.dog_information.size;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SizeMapper {



    @Mapping(source = "id", target = "sizeId")
    @Mapping(source = "type", target = "sizeType")
    @Mapping(source = "price", target = "sizePrice")
    SizeDto toDto(Size size);
    List<SizeDto> sizeToSizeDto(List<Size> size);

}
