package ee.valiit.back_doge_v2.business.order.service;

import ee.valiit.back_doge_v2.business.order.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.user.service.UserService;
import ee.valiit.back_doge_v2.domain.order_information.city.City;
import ee.valiit.back_doge_v2.domain.order_information.city.CityRepository;
import ee.valiit.back_doge_v2.domain.order_information.walking.Walking;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingMapper;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingRepository;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WalkingRegistrationService {

    @Resource
    private UserService userService;


    @Resource
    private CityRepository cityRepository;

    @Resource
    private WalkingMapper walkingMapper;

    @Resource
    private WalkingRepository walkingRepository;

    public void addNewWalking(WalkingRequest request) {
        User user = userService.getUserById(request.getUserId());
        City city = cityRepository.findById(request.getCityId()).get();
        Walking walking = walkingMapper.toEntity(request);
        walking.setWalkerUser(user);
        walking.setCity(city);
        walkingRepository.save(walking);


        System.out.println();
    }


}
