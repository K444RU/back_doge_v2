package ee.valiit.back_doge_v2.domain.walker_information.size;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SizeMapper {
    Size sizeDtoToSize(SizeDto sizeDto);

    SizeDto sizeToSizeDto(Size size);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Size updateSizeFromSizeDto(SizeDto sizeDto, @MappingTarget Size size);
}
