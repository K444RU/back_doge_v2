package ee.valiit.back_doge_v2.domain.order_information.walking;

import ee.valiit.back_doge_v2.business.dog.dto.WalkerSearchRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalTime;
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

    public List<Walking> findAnyDogSizeWalkingsBy(Integer cityId, LocalDate date, String status) {
        return walkingRepository.findWalkingsBy(cityId, date, status);
    }

    public List<Walking> findAnyDogSizeWalkingsBy(WalkerSearchRequest request) {
        LocalTime timeFrom = LocalTime.of(request.getTimeFrom(), 0);
        LocalTime timeTo = LocalTime.of(request.getTimeTo(), 0);

        return walkingRepository.findWalkingsBy(request.getCityId(), "A", request.getDate(), timeFrom, timeTo);
    }
}
