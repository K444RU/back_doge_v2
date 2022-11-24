package ee.valiit.back_doge_v2.domain.controllers;

import ee.valiit.back_doge_v2.domain.dog_information.breeds.Breed;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedMapper;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DogService {

    @Resource
    private BreedMapper breedMapper;

    @Resource
    private BreedRepository breedRepository;

public List<BreedDto> getAllBreeds() {
    List<Breed> allBreeds = breedRepository.findAll();
    List<BreedDto> result = breedMapper.breedToBreedDto(allBreeds);
    return result;
}



}




