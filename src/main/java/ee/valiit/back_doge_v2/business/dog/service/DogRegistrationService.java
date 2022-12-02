package ee.valiit.back_doge_v2.business.dog.service;

import ee.valiit.back_doge_v2.business.dog.dto.DogRegistrationRequest;
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
    private BreedMapper breedMapper;
    @Resource
    private BreedRepository breedRepository;
    @Resource
    private SizeMapper sizeMapper;
    @Resource
    private SizeRepository sizeRepository;
    @Resource
    private UserRepository userRepository;
    @Resource
    private DogMapper dogMapper;
    @Resource
    private DogRepository dogRepository;

    public List<BreedDto> getAllBreeds() {
        List<Breed> allEntities = breedRepository.findAll();
        List<BreedDto> breedAllDtos = breedMapper.breedToBreedDto(allEntities);
        return breedAllDtos;
    }

    public List<SizeDto> getAllSizes() {
        List<Size> allEntities = sizeRepository.findAll();
        List<SizeDto> sizeAllDtos = sizeMapper.sizeToSizeDto(allEntities);
        return sizeAllDtos;
    }

    public void addNewDog(DogRegistrationRequest request) {
        User validUser = getValidUser(request.getUserId());
        Breed validBreed = getValidBreed(request.getBreedId());
        Size validSize = getValidSize(request.getSizeId());
        Dog dog = dogMapper.dogRequestToDog(request);
        dog.setOwnerUser(validUser);
        dog.setBreed(validBreed);
        dog.setSize(validSize);
        dogRepository.save(dog);
    }

    private User getValidUser(Integer ownerUserId) {
        Optional<User> optionalUser = userRepository.findById(ownerUserId);
        User user = optionalUser.get();
        return user;
    }

    private Breed getValidBreed(Integer dogBreedId) {
        Optional<Breed> optionalBreed = breedRepository.findById(dogBreedId);
        Breed breed = optionalBreed.get();
        return breed;
    }

    private Size getValidSize(Integer dogSizeId) {
        Optional<Size> optionalSize = sizeRepository.findById(dogSizeId);
        Size size = optionalSize.get();
        return size;
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




