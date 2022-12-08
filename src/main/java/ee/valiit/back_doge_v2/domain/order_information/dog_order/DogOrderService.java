package ee.valiit.back_doge_v2.domain.order_information.dog_order;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DogOrderService {

    @Resource
    private DogOrderRepository dogOrderRepository;

    public void save(DogOrder dogOrder) {
        dogOrderRepository.save(dogOrder);
    }

    public List<DogOrder> findOrdersBy(Integer userId) {
        return dogOrderRepository.findBy(userId);
    }
}
