package ee.valiit.back_doge_v2.domain.order_information.walking;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class WalkingService {

    @Resource
    private WalkingRepository walkingRepository;

    public void save(Walking walking) {
        walkingRepository.save(walking);
    }

    public Walking findById(Integer walkingId) {
        return walkingRepository.findById(walkingId).get();
    }

    public List<Walking> findWalkingByUserId(Integer userId, String status) {
        return walkingRepository.findWalkingByUserId(userId, status);
    }

    public List<Walking> findWalkingsBy(Integer cityId, LocalDate date, String status) {
        return walkingRepository.findWalkingsBy(cityId, date, status);
    }

    public void deleteWalkingBy(Integer walkingId) {
        if (walkingRepository.findById(walkingId).isPresent()) {
            Walking walking = walkingRepository.findById(walkingId).get();
            walkingRepository.delete(walking);
        }

    }
}
