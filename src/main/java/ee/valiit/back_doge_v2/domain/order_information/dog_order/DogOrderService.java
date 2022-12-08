package ee.valiit.back_doge_v2.domain.order_information.dog_order;

import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
import ee.valiit.back_doge_v2.domain.order_information.order.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DogOrderService {

    @Resource
    private DogOrderRepository dogOrderRepository;

    public void save(DogOrder dogOrder) {
        dogOrderRepository.save(dogOrder);
    }

    public List<Dog> findDogBy(Integer orderId) {
        List<DogOrder> dogNames = dogOrderRepository.findDogNameByOrderId(orderId);
        List<Dog> dogs = new ArrayList<>();
        for (DogOrder dogName : dogNames) {
            dogs.add(dogName.getDog());
        }
        return dogs;


    }
    public List<Order> findOrdersByOrderId(Integer dogId) {
        List<DogOrder> orders = dogOrderRepository.findByDogId(dogId);
        List<Order> orderResponses = new ArrayList<>();
        for (DogOrder order : orders) {
            orderResponses.add(order.getOrder());
        }
        return orderResponses;
    }
}
