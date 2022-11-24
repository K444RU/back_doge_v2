package ee.valiit.back_doge_v2.domain.controllers;

import ee.valiit.back_doge_v2.domain.dog_information.breeds.Breed;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedMapper;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedRepository;
import ee.valiit.back_doge_v2.domain.walker_information.size.Size;
import ee.valiit.back_doge_v2.domain.walker_information.size.SizeDto;
import ee.valiit.back_doge_v2.domain.walker_information.size.SizeMapper;
import ee.valiit.back_doge_v2.domain.walker_information.size.SizeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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


    public List<BreedDto> getAllBreeds() {
      List<Breed> allEntities = breedRepository.findAll();
      List<BreedDto> allDtos = breedMapper.breedToBreedDto(allEntities);
      return allDtos;
    }
    //Väljastab kõike tõuge

    public List<SizeDto> getAllSizes() {
        List<Size> allEntities = sizeRepository.findAll();
        List<SizeDto> allDtos = sizeMapper.sizeToSizeDto(allEntities);
        return allDtos;
    }
    //Väljastab kõike suurusi

}




