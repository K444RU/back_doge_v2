package ee.valiit.back_doge_v2.business.order;


import ee.valiit.back_doge_v2.business.dog.dto.DogDtoToOrderRequest;
import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogService;
import ee.valiit.back_doge_v2.domain.order_information.dog_order.DogOrder;
import ee.valiit.back_doge_v2.domain.order_information.dog_order.DogOrderService;
import ee.valiit.back_doge_v2.domain.order_information.order.Order;
import ee.valiit.back_doge_v2.domain.order_information.order.OrderMapper;
import ee.valiit.back_doge_v2.domain.order_information.order.OrderService;
import ee.valiit.back_doge_v2.domain.order_information.walking.Walking;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrdersService {

    @Resource
    private WalkingService walkingService;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderService orderService;

    @Resource
    private DogService dogService;

    @Resource
    private DogOrderService dogOrderService;

    public void addNewOrder(OrderRequest request) {
        Walking walking = walkingService.findById(request.getWalkingId());
        Order order = orderMapper.toEntity(request);
        order.setWalking(walking);
        orderService.save(order);
        createDogOrder(request, order);
    }

    private void createDogOrder(OrderRequest request, Order order) {
        List<DogDtoToOrderRequest> dogs = request.getDog();
        for (DogDtoToOrderRequest dog : dogs) {
            if (dog.getIsSelected()) {
                Integer dogId = dog.getDogId();
                Dog dogFromEntity = dogService.findById(dogId);
                DogOrder dogOrder = new DogOrder();
                dogOrder.setDog(dogFromEntity);
                dogOrder.setOrder(order);
                dogOrderService.save(dogOrder);
            }
        }
    }

    public List<Order> findOrdersBy(Integer walkingId, LocalDate walkingDate) {
        return orderService.findOrdersBy(walkingId, walkingDate);
    }
}
