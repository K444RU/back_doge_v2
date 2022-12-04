package ee.valiit.back_doge_v2.domain.dog_information.dog;

import ee.valiit.back_doge_v2.business.dog.dto.DogRegistrationRequest;
import ee.valiit.back_doge_v2.business.dog.dto.OwnerHomePageDogInfoResponse;
import ee.valiit.back_doge_v2.business.dog.dto.dogNameDropdownByUserId;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DogMapper {

    @Mapping(source = "ownerUserId", target = "ownerUser")
    @Mapping(source = "breedId", target = "breed")
    @Mapping(source = "sizeId", target = "size")
    Dog dogDtoToDog(DogDto dogDto);

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
    OwnerHomePageDogInfoResponse ownerHomePageDogInfoResponse(Dog userById);

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

    List<DogDto> dogDtoToDog(List<Dog> allDogs);


    @Mapping(source = "id", target = "dogId")
    @Mapping(source = "name", target = "dogName")
    dogNameDropdownByUserId dogNamesDropdownByUserId(Dog dogByUserId);
    List<dogNameDropdownByUserId> dogsNamesDropdownByUserId(List<Dog> dogsByUserId);
}
