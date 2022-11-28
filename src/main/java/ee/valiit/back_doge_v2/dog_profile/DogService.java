package ee.valiit.back_doge_v2.dog_profile;

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
public class DogService {

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
    //Väljastab kõike tõuge

    public List<SizeDto> getAllSizes() {
        List<Size> allEntities = sizeRepository.findAll();
        List<SizeDto> sizeAllDtos = sizeMapper.sizeToSizeDto(allEntities);
        return sizeAllDtos;
    }
    //Väljastab kõike suurusi

    public void addNewDog(DogRequest request) {

        User user = getValidUser(request.getOwnerUserId());
        Size validSize = getValidSize(request.getDogSizeId());

        Dog dog = dogMapper.dogRequestToDog(request);

        dog.setOwnerUser(user);

//        dog.setOwnerUser(user);
        dog.setSize(validSize);
        dogRepository.save(dog);


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

    private Size getValidSize(Integer dogSizeId) {
        Optional<Size> optionalSize = sizeRepository.findById(dogSizeId);
        if (optionalSize.isEmpty()) {
            System.out.println("Size not found");
        }

        Size size = optionalSize.get();
        return size;
    }

    //    @org.jetbrains.annotations.NotNull
    private User getValidUser(Integer ownerUserId) {
        Optional<User> optionalUser = userRepository.findById(ownerUserId);
        if (optionalUser.isEmpty()) {
            System.out.println("User not found");
        }

        User user = optionalUser.get();
        return user;
    }

}




