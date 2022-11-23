package ee.valiit.back_doge_v2.domain.walker_information.walking;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WalkingMapper {
    Walking walkingDtoToWalking(WalkingDto walkingDto);

    WalkingDto walkingToWalkingDto(Walking walking);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Walking updateWalkingFromWalkingDto(WalkingDto walkingDto, @MappingTarget Walking walking);
}
