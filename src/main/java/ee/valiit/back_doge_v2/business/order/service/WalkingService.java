package ee.valiit.back_doge_v2.business.order.service;

import ee.valiit.back_doge_v2.business.order.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.user.service.UserService;
import ee.valiit.back_doge_v2.domain.dog_information.size.Size;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeDto;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeRepository;
import ee.valiit.back_doge_v2.domain.order_information.city.City;
import ee.valiit.back_doge_v2.domain.order_information.city.CityRepository;
import ee.valiit.back_doge_v2.domain.order_information.walking.Walking;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingMapper;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingRepository;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSize;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSizeRepository;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class WalkingService {

    @Resource
    private UserService userService;


    @Resource
    private CityRepository cityRepository;

    @Resource
    private WalkingMapper walkingMapper;

    @Resource
    private WalkingRepository walkingRepository;

    @Resource
    private SizeRepository sizeRepository;

    @Resource
    private WalkingSizeRepository walkingSizeRepository;

    public void addNewWalking(WalkingRequest request) {
        User user = userService.getUserById(request.getUserId());
        City city = cityRepository.findById(request.getCityId()).get();
        Walking walking = walkingMapper.toEntity(request);
        walking.setUser(user);
        walking.setCity(city);
        walkingRepository.save(walking);
        createWalkingSize(request, walking);
    }

    private void createWalkingSize(WalkingRequest request, Walking walking) {
        List<SizeDto> sizes = request.getSizeTypes();
        for (SizeDto size : sizes) {
            if (size.getIsSelected()) {
                Integer sizeId = size.getSizeId();
                Size sizeFromEntity = sizeRepository.findById(sizeId).get();
                WalkingSize walkingSize = new WalkingSize();
                walkingSize.setWalking(walking);
                walkingSize.setSize(sizeFromEntity);
                walkingSizeRepository.save(walkingSize);

            }
        }
    }

    public Walking findWalkingById(Integer walkingId) {
        Optional<Walking> optionalWalking = walkingRepository.findById(walkingId);
        return optionalWalking.get();
    }


}
