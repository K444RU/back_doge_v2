package ee.valiit.back_doge_v2.business.order.service;

import ee.valiit.back_doge_v2.business.dog.dto.DogInfo;
import ee.valiit.back_doge_v2.business.dog.dto.DogStatusUpdate;
import ee.valiit.back_doge_v2.business.dog.dto.OwnerHomePageDogInfoResponse;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.Breed;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedMapper;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedRepository;
import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogMapper;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogRepository;
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
    private DogMapper dogMapper;

    @Resource
    private DogRepository dogRepository;

    @Resource
    private BreedRepository breedRepository;
    @Resource
    private BreedMapper breedMapper;

    @Resource
    private SizeRepository sizeRepository;

    @Resource
    private SizeMapper sizeMapper;

    public List<OwnerHomePageDogInfoResponse> getDogInfoByUserId(Integer userId) {
        List<Dog> dogsByUserId = dogRepository.findDogsByUserId(userId, "A");
        return dogMapper.ownerHomePageDogsInfoResponse(dogsByUserId);

    }

    public List<DogInfo> getDogNameByUserId(Integer userId) {
        List<Dog> dogsByUserId = dogRepository.findDogsByUserId(userId, "A");
        return dogMapper.dogsNamesDropdownByUserId(dogsByUserId);
    }

    public Breed getValidBreed(Integer dogBreedId) {
        Optional<Breed> optionalBreed = breedRepository.findById(dogBreedId);
        return optionalBreed.get();
    }

    public Size getValidSize(Integer dogSizeId) {
        Optional<Size> optionalSize = sizeRepository.findById(dogSizeId);
        return optionalSize.get();
    }

    public List<SizeDto> getAllSizes() {
        List<Size> allEntities = sizeRepository.findAll();
        return sizeMapper.sizeToSizeDto(allEntities);
    }

    public List<BreedDto> getAllBreeds() {
        List<Breed> allEntities = breedRepository.findAll();
        List<BreedDto> breedAllDtos = breedMapper.breedToBreedDto(allEntities);
        return breedAllDtos;
    }


    public void updateDogStatus(Integer dogId, DogStatusUpdate request) {
        Dog dog = dogRepository.findById(dogId).get();
        dogMapper.updateDogStatus(request, dog);
        dogRepository.save(dog);

    }

}
