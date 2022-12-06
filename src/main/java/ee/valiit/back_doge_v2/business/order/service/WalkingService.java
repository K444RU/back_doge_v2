package ee.valiit.back_doge_v2.business.order.service;

import ee.valiit.back_doge_v2.business.order.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkingResponse;
import ee.valiit.back_doge_v2.business.user.service.UserService;
import ee.valiit.back_doge_v2.domain.dog_information.size.*;
import ee.valiit.back_doge_v2.domain.order_information.city.City;
import ee.valiit.back_doge_v2.domain.order_information.city.CityRepository;
import ee.valiit.back_doge_v2.domain.order_information.walking.Walking;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingMapper;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingRepository;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSize;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSizeDto;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSizeMapper;
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
    private SizeMapper sizeMapper;



    @Resource
    private WalkingSizeMapper walkingSizeMapper;

    @Resource
    private WalkingSizeService walkingSizeService;

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
        List<SizeDto> sizes = request.getSizes();
        for (SizeDto size : sizes) {
            if (size.getIsSelected()) {
                Integer sizeId = size.getSizeId();
                Size sizeFromEntity = sizeRepository.findById(sizeId).get();
                WalkingSize walkingSize = new WalkingSize();
                walkingSize.setWalking(walking);
                walkingSize.setSize(sizeFromEntity);
                walkingSizeService.addWalkingSize(walkingSize);
            }
        }
    }



    public Walking getWalkingById(Integer walkingId) {
        Optional<Walking> optionalWalking = walkingRepository.findById(walkingId);
        return optionalWalking.get();
    }

//    public List<WalkingResponse> getAllWalkingByUserId(Integer userId) {
//        List<WalkingSize> walkingByUserId = walkingSizeRepository.findWalkingByUserId(userId);
//        for (WalkingSize walkings : walkingByUserId) {
//            if (walkings.getWalking().getStatus().equals('I')) {
//                return null;
//            }
//        }
//        return walkingSizeMapper.walkingsInfoResponse(walkingByUserId);
//    }

    public List<WalkingResponse> getUserAllWalkingsByUserId(Integer userId) {
        List<Walking> walkings = walkingRepository.findWalkingByUserId(userId, "A");
        List<WalkingResponse> walkingDtos = createWalkingDtos(walkings);
        return walkingDtos;
    }

    private List<WalkingResponse> createWalkingDtos(List<Walking> walkingByUserId) {
        List<WalkingResponse> walkingResponses = walkingMapper.fromEntityToResponses(walkingByUserId);
        addWalkingSizeType(walkingResponses);
        return walkingResponses;
    }

    private void addWalkingSizeType(List<WalkingResponse> walkingResponses) {
        for (WalkingResponse walkingResponse : walkingResponses) {
            addSizeTypeToWalkingResponse(walkingResponse);
            System.out.println();
        }
    }

    public void addSizeTypeToWalkingResponse(WalkingResponse response) {
        List<Size> sizes = walkingSizeService.findSizeBy(response.getWalkingId());
        List<WalkingSizeDto> sizeDtos = sizeMapper.fromEntityToWalkingSizeDtos(sizes);
        response.setSizeTypes(sizeDtos);

    }
}
