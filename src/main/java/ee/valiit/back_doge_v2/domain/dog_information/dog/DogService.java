package ee.valiit.back_doge_v2.domain.dog_information.dog;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DogService {

    @Resource
    private DogRepository dogRepository;

    public List<Dog> findDogsByUserId(Integer userId, String status) {
        return dogRepository.findDogsByUserId(userId, status);
    }

    public Dog findById(Integer dogId) {
        return dogRepository.findById(dogId).get();
    }


    public void save(Dog dog) {
        dogRepository.save(dog);
    }

    public List<Dog> findBy(Integer dogId) {
        return dogRepository.findBy(dogId);

    }
}
