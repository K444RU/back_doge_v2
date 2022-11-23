package ee.valiit.back_doge_v2.domain.walker_information.walking_size;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WalkingSizeMapper {
    WalkingSize walkingSizeDtoToWalkingSize(WalkingSizeDto walkingSizeDto);

    WalkingSizeDto walkingSizeToWalkingSizeDto(WalkingSize walkingSize);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    WalkingSize updateWalkingSizeFromWalkingSizeDto(WalkingSizeDto walkingSizeDto, @MappingTarget WalkingSize walkingSize);
}
