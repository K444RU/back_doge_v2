package ee.valiit.back_doge_v2.domain.controllers;

import ee.valiit.back_doge_v2.domain.dog_information.breed.BreedRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DogService {

    @Resource
    private BreedMapper breedMapper;

    @Resource
    private BreedRepository breedRepository;



}




