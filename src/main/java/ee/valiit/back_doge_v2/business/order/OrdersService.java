package ee.valiit.back_doge_v2.business.order;


import ee.valiit.back_doge_v2.business.dog.dto.DogDtoToOrderRequest;
import ee.valiit.back_doge_v2.business.dog.dto.OrderedDog;
import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkerActiveOrderResponse;
import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogMapper;
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
import java.time.LocalTime;
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
    private DogMapper dogMapper;

    @Resource
    private DogOrderService dogOrderService;




    public void addNewOrder(OrderRequest request) {
        Walking walking = walkingService.findById(request.getWalkingId());
        Order order = orderMapper.toEntity(request);
        order.setTimeFrom(LocalTime.of(request.getTimeFrom(), 0));
        order.setTimeTo(LocalTime.of(request.getTimeTo(), 0));
        order.setWalking(walking);
        orderService.save(order);
        createDogOrder(request, order);
    }

    private void createDogOrder(OrderRequest request, Order order) {
        List<DogDtoToOrderRequest> dogs = request.getDogs();
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

    public List<WalkerActiveOrderResponse> getWalkerActiveOrders(Integer userId) {
        List<Order> orders = orderService.findOrdersBy(userId);
        List<WalkerActiveOrderResponse> orderResponses = orderMapper.entityToOrdersResponses(orders);
        addOrderDogName(orderResponses);
        return orderResponses;
    }

    private void addOrderDogName(List<WalkerActiveOrderResponse> orderResponses) {
        for (WalkerActiveOrderResponse orderResponse : orderResponses) {
            addDogNameToWalkerOrderResponse(orderResponse);
        }

    }

    private void addDogNameToWalkerOrderResponse(WalkerActiveOrderResponse response) {
        List<Dog> dogNames = dogOrderService.findDogBy(response.getOrderId());
        List<OrderedDog> orderedDogs = dogMapper.entityToOrdersResponses(dogNames);
        response.setDogs(orderedDogs);
    }
}
