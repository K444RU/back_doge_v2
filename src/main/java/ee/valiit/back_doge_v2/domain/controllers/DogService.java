package ee.valiit.back_doge_v2.domain.controllers;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DogService {

    @Resource
    private BreedMapper breedMapper;

    @Resource
    private BreedRepository breedRepository;



}




