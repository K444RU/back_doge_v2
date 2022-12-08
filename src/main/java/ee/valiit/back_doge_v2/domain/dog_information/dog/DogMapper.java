package ee.valiit.back_doge_v2.domain.dog_information.dog;

import ee.valiit.back_doge_v2.business.dog.dto.*;
import ee.valiit.back_doge_v2.business.order.dto.OwnerActiveOrdersResponse;
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

    @Mapping(source = "id", target = "dogId")
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
    DogInfo dogNameDropdownByUserId(Dog dogByUserId);
    List<DogInfo> dogsNamesDropdownByUserId(List<Dog> dogsByUserId);

    @Mapping(constant = "I", target = "status")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDogStatus(DogStatusUpdate dogStatusUpdate, @MappingTarget Dog dog);

    @Mapping(source = "name", target = "dogName")
    OrderedDog entityToOrdersResponse(Dog dogName);
    List<OrderedDog> entityToOrdersResponses(List<Dog> dogNames);

    @Mapping(source = "id", target = "dogId")
    @Mapping(source = "name", target = "dogName")
    OwnerActiveOrdersResponse entityToOwnerResponse(Dog dogName);
    List<OwnerActiveOrdersResponse> entityToOwnerResponses(List<Dog> dogNames);
}
