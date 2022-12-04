package ee.valiit.back_doge_v2.business.order.service;


import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import ee.valiit.back_doge_v2.business.user.service.UserService;
import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogDto;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogMapper;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogRepository;
import ee.valiit.back_doge_v2.domain.order_information.city.City;
import ee.valiit.back_doge_v2.domain.order_information.city.CityDto;
import ee.valiit.back_doge_v2.domain.order_information.city.CityMapper;
import ee.valiit.back_doge_v2.domain.order_information.city.CityRepository;
import ee.valiit.back_doge_v2.domain.order_information.order.Order;
import ee.valiit.back_doge_v2.domain.order_information.order.OrderMapper;
import ee.valiit.back_doge_v2.domain.order_information.walking.Walking;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingRepository;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
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
    private WalkingRepository walkingRepository;

    @Resource
    private OrderMapper orderMapper;






    public List<CityDto> getAllCities() {
        List<City> allCities = cityRepository.findAll();
        List<CityDto> allCitiesDto = cityMapper.cityToCityDto(allCities);
        return allCitiesDto;
    }


//    public void addNewOrder(OrderRequest request){
//        Walking walking = walkingRepository.getReferenceById(request.getWalkingId());
//        Order order = orderMapper.toEntity(request);
//
//
//
//
//    }




}





