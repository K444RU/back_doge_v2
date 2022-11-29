package ee.valiit.back_doge_v2.domain.dog_information.dog;

import ee.valiit.back_doge_v2.business.dog_profile.DogRegistrationRequest;
import jdk.jfr.Name;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;

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
    Dog dogRequestToDog(DogRegistrationRequest request);


    @Named("byteArrayToString")
    static byte[] byteArrayToString(String dogPhoto) {
        byte[] bytes = dogPhoto.getBytes(StandardCharsets.UTF_8);
        return bytes;

    }
//    @Named("byteArrayToString")
//    static String byteArrayToString(byte[] dogPicture) {
//        if (dogPicture == null) {
//            System.out.println("Koeral puudub pilt, palun salvestage selle");
//        }
//        String pictureAsString = new String(dogPicture);
//        return pictureAsString;
//    }
    //Tulevikuks --> meetod muudab koera tööpi byte[]`st String´iks


}
