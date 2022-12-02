package ee.valiit.back_doge_v2.business.dog.service;

import ee.valiit.back_doge_v2.business.dog.dto.OwnerHomePageDogInfoResponse;
import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogMapper;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class DogService {

    @Resource
    private DogMapper dogMapper;

    @Resource
    private DogRepository dogRepository;

    public OwnerHomePageDogInfoResponse getDogInfoByUserId(Integer userId) {
        Dog dogByUserId = getDogByUserId(userId);
        return dogMapper.ownerHomePageDogInfoResponse(dogByUserId);
    }

    private Dog getDogByUserId(Integer userId) {
        Optional<Dog> optionalUser = dogRepository.findByOwnerUserId(userId);
        return optionalUser.get();
    }
}
