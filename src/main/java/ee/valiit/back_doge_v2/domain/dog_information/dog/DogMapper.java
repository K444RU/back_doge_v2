package ee.valiit.back_doge_v2.domain.dog_information.dog;

import ee.valiit.back_doge_v2.dog_profile.DogRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DogMapper {
    @Mapping(source = "ownerUserId", target = "ownerUser")
    @Mapping(source = "breedId", target = "breed")
    @Mapping(source = "sizeId", target = "size")
    Dog dogDtoToDog(DogDto dogDto);

    @Mapping(source = "dogName", target = "name")
    @Mapping(source = "dogAge", target = "age")
    @Mapping(source = "dogAdditionalInformation", target = "additionalInformation")
    Dog dogRequestToDog(DogRequest request);

//    @Mapping(source = "dogName", target = "name")
//    @Mapping(source = "dogAge", target = "age")
//    @Mapping(source = "dogAdditionalInformation", target = "additionalInformation")
//    Dog dogRequestToDog(DogRequest request);

}
