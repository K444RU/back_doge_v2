package ee.valiit.back_doge_v2.business.order.service;


import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogDto;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogRepository;
import ee.valiit.back_doge_v2.domain.order_information.city.City;
import ee.valiit.back_doge_v2.domain.order_information.city.CityDto;
import ee.valiit.back_doge_v2.domain.order_information.city.CityMapper;
import ee.valiit.back_doge_v2.domain.order_information.city.CityRepository;
import ee.valiit.back_doge_v2.domain.order_information.dog_order.DogOrder;
import ee.valiit.back_doge_v2.domain.order_information.dog_order.DogOrderRepository;
import ee.valiit.back_doge_v2.domain.order_information.order.Order;
import ee.valiit.back_doge_v2.domain.order_information.order.OrderMapper;
import ee.valiit.back_doge_v2.domain.order_information.order.OrderRepository;
import ee.valiit.back_doge_v2.domain.order_information.walking.Walking;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private CityMapper cityMapper;

    @Resource
    private CityRepository cityRepository;

    @Resource
    private WalkingService walkingService;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private DogRepository dogRepository;

    @Resource
    private DogOrderRepository dogOrderRepository;


    public List<CityDto> getAllCities() {
        List<City> allCities = cityRepository.findAll();
        List<CityDto> allCitiesDto = cityMapper.cityToCityDto(allCities);
        return allCitiesDto;
    }


    public void addNewOrder(OrderRequest request){
        Walking walking = walkingService.findWalkingById(request.getWalkingId());
        Order order = orderMapper.toEntity(request);
        order.setWalking(walking);
        orderRepository.save(order);
        createDogOrder(request, order);
    }

    private void createDogOrder(OrderRequest request, Order order) {
        List<DogDto> dogs = request.getDogs();
        for (DogDto dog : dogs) {
            if (dog.getStatus().equals('A')) {
                Integer dogId = dog.getId();
                Dog dogFromEntity = dogRepository.findById(dogId).get();
                DogOrder dogOrder = new DogOrder();
                dogOrder.setDog(dogFromEntity);
                dogOrder.setOrder(order);
                dogOrderRepository.save(dogOrder);
            }
        }
    }


}





