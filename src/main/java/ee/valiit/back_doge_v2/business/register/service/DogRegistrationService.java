package ee.valiit.back_doge_v2.business.register.service;

import ee.valiit.back_doge_v2.business.dog.dto.DogRegistrationRequest;
import ee.valiit.back_doge_v2.business.dog.service.DogService;
import ee.valiit.back_doge_v2.business.user.service.UserService;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.Breed;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedMapper;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedRepository;
import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogMapper;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogRepository;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserRepository;
import ee.valiit.back_doge_v2.domain.dog_information.size.Size;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeDto;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeMapper;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class DogRegistrationService {


    @Resource
    private DogMapper dogMapper;
    @Resource
    private DogRepository dogRepository;

    @Resource
    private UserService userService;

    @Resource
    private DogService dogService;



    public void addNewDog(DogRegistrationRequest request) {
        User validUser = userService.getUserById(request.getUserId());
        Breed validBreed = dogService.getValidBreed(request.getBreedId());
        Size validSize = dogService.getValidSize(request.getSizeId());
        Dog dog = dogMapper.dogRequestToDog(request);
        dog.setUser(validUser);
        dog.setBreed(validBreed);
        dog.setSize(validSize);
        dogRepository.save(dog);
    }

    //        Optional<User> optionalUser = userRepository.findById(request.getOwnerUserId());
//        if (optionalUser.isEmpty()) {
//            System.out.println("User not found! You should register that user.");
//        }
//        User userNewDog = optionalUser.get();
//        DogDto dogDto = new DogDto(userNewDog.ge(), request.getDogName(), request.getDogAge(), request.getDogAdditionalInformation());
//        Dog dog = dogMapper.dogDtoToDog(dogDto);
//        dog.setOwnerUser(userNewDog);
//        dogRepository.save(dog);

}




