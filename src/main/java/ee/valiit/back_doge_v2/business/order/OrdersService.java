package ee.valiit.back_doge_v2.business.order;


import ee.valiit.back_doge_v2.business.dog.dto.CityDto;
import ee.valiit.back_doge_v2.business.dog.dto.DogDtoToOrderRequest;
import ee.valiit.back_doge_v2.business.dog.dto.WalkerSearchRequest;
import ee.valiit.back_doge_v2.business.order.dto.AllActiveWalkingResponse;
import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkingResponse;
import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogRepository;
import ee.valiit.back_doge_v2.domain.order_information.city.City;
import ee.valiit.back_doge_v2.domain.order_information.city.CityMapper;
import ee.valiit.back_doge_v2.domain.order_information.city.CityService;
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
    private CityMapper cityMapper;

    @Resource
    private CityService cityService;

    @Resource
    private WalkingService walkingService;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderService orderService;

    @Resource
    private DogRepository dogRepository;

    @Resource
    private DogOrderService dogOrderService;


    public List<CityDto> getAllCities() {
        List<City> allCities = cityService.findAllCities();
        return cityMapper.cityToCityDto(allCities);
    }

    public void addNewOrder(OrderRequest request) {
        Walking walking = walkingService.getWalkingById(request.getWalkingId());
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
                Dog dogFromEntity = dogRepository.findById(dogId).get();
                DogOrder dogOrder = new DogOrder();
                dogOrder.setDog(dogFromEntity);
                dogOrder.setOrder(order);
                dogOrderService.save(dogOrder);
            }
        }
    }

    public void addNewWalking(WalkingRequest request) {
        walkingService.addNewWalking(request);
    }

    public List<WalkingResponse> getUserAllWalkingsByUserId(Integer userId) {
        return walkingService.getUserAllWalkingsByUserId(userId);
    }

    public List<AllActiveWalkingResponse> getAllActiveWalkers(WalkerSearchRequest request) {
        return walkingService.getAllActiveWalkers(request);
    }

    public List<Order> findOrdersBy(Integer walkingId, LocalDate walkingDate) {
        return orderService.findOrdersBy(walkingId, walkingDate);
    }
}





