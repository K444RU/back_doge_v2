package ee.valiit.back_doge_v2.domain.dog_information.dog;

import ee.valiit.back_doge_v2.business.dog.dto.DogNameDropdownByUserId;
import ee.valiit.back_doge_v2.business.dog.dto.DogRegistrationRequest;
import ee.valiit.back_doge_v2.business.dog.dto.DogStatusUpdate;
import ee.valiit.back_doge_v2.business.dog.dto.OwnerHomePageDogInfoResponse;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DogMapper {

    @Mapping(source = "dogName", target = "name")
    @Mapping(source = "dogAge", target = "age")
    @Mapping(source = "dogAdditionalInformation", target = "additionalInformation")
    @Mapping(source = "dogPhoto", target = "dogPhoto", qualifiedByName = "byteArrayToString")
    @Mapping(constant = "A", target = "status")
    Dog dogRequestToDog(DogRegistrationRequest request);

    @Mapping(source = "name", target = "dogName")
    @Mapping(source = "age", target = "dogAge")
    @Mapping(source = "additionalInformation", target = "dogAdditionalInformation")
    @Mapping(source = "size.type", target = "dogSizeType")
    @Mapping(source = "breed.name", target = "dogBreed")
    @Mapping(source = "dogPhoto", target = "dogPhoto", qualifiedByName = "dogPhotoToString")
    OwnerHomePageDogInfoResponse ownerHomePageDogInfoResponse(Dog dogByUserId);
    List<OwnerHomePageDogInfoResponse> ownerHomePageDogsInfoResponse(List<Dog> dogsByUserId);



    @Named("byteArrayToString")
    static byte[] byteArrayToString(String dogPhoto) {
        byte[] bytes = dogPhoto.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

    @Named("dogPhotoToString")
    static String dogPhotoToString(byte[] dogPhoto) {
        if (dogPhoto == null) {
            return null;
        }
        String pictureAsString = new String(dogPhoto);
        return pictureAsString;
    }


    @Mapping(source = "id", target = "dogId")
    @Mapping(source = "name", target = "dogName")
    DogNameDropdownByUserId dogNameDropdownByUserId(Dog dogByUserId);
    List<DogNameDropdownByUserId> dogsNamesDropdownByUserId(List<Dog> dogsByUserId);

    @Mapping(source = "dogStatus", target = "status")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDogStatus(DogStatusUpdate dogStatusUpdate, @MappingTarget Dog dog);
}
