package ee.valiit.back_doge_v2.domain.walker_information.size;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SizeMapper {
    Size sizeDtoToSize(SizeDto sizeDto);

    List<SizeDto> sizeToSizeDto(List<Size> size);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Size updateSizeFromSizeDto(SizeDto sizeDto, @MappingTarget Size size);
}
