package ee.valiit.back_doge_v2.domain.dog_information.breed;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class BreedService {

    @Resource
    private BreedRepository breedRepository;


    public List<Breed> findAllBreeds() {
        return breedRepository.findAll();
    }

    public Breed getValidBreed(Integer dogBreedId) {
        Optional<Breed> optionalBreed = breedRepository.findById(dogBreedId);
        return optionalBreed.get();
    }

}
