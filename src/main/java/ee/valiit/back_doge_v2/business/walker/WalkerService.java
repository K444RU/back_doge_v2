package ee.valiit.back_doge_v2.business.walker;

import ee.valiit.back_doge_v2.business.dog.dto.DogInfo;
import ee.valiit.back_doge_v2.business.form.dto.DogSizeDto;
import ee.valiit.back_doge_v2.business.dog.dto.WalkerSearchRequest;
import ee.valiit.back_doge_v2.business.dog.dto.WalkingSizeDto;
import ee.valiit.back_doge_v2.business.walker.dto.AllActiveWalkingResponse;
import ee.valiit.back_doge_v2.business.walker.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.walker.dto.WalkingResponse;
import ee.valiit.back_doge_v2.business.user.UsersService;
import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogService;
import ee.valiit.back_doge_v2.domain.dog_information.size.Size;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeMapper;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeService;
import ee.valiit.back_doge_v2.domain.order_information.city.City;
import ee.valiit.back_doge_v2.domain.order_information.city.CityService;
import ee.valiit.back_doge_v2.domain.order_information.order.Order;
import ee.valiit.back_doge_v2.domain.order_information.order.OrderService;
import ee.valiit.back_doge_v2.domain.order_information.walking.Walking;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingMapper;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingService;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSize;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSizeService;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class WalkerService {

    @Resource
    private DogService dogService;

    @Resource
    private CityService cityService;

    @Resource
    private OrderService orderService;

    @Resource
    private UsersService usersService;

    @Resource
    private SizeService sizeService;

    @Resource
    private WalkingService walkingService;

    @Resource
    private WalkingSizeService walkingSizeService;

    @Resource
    private SizeMapper sizeMapper;

    @Resource
    private WalkingMapper walkingMapper;

    public void addNewWalking(WalkingRequest request) {
        User user = usersService.getUserById(request.getUserId());
        City city = cityService.findById(request.getCityId());
        Walking walking = walkingMapper.toEntity(request);
        walking.setTimeFrom(LocalTime.of(request.getTimeFrom(), 0));
        walking.setTimeTo(LocalTime.of(request.getTimeTo(), 0));
        walking.setUser(user);
        walking.setCity(city);
        walkingService.save(walking);
        createWalkingSize(request, walking);
    }

    public List<WalkingResponse> getUserAllWalkingsByUserId(Integer userId) {
        List<Walking> walkings = walkingService.findWalkingByUserId(userId, "A");
        List<WalkingResponse> walkingDtos = createWalkingDtos(walkings);
        return walkingDtos;
    }



    public void addSizeTypeToWalkingResponse(WalkingResponse response) {
        List<Size> sizes = walkingSizeService.findSizeBy(response.getWalkingId());
        List<WalkingSizeDto> sizeDtos = sizeMapper.fromEntityToWalkingSizeDtos(sizes);
        response.setSizeTypes(sizeDtos);

    }

    public List<AllActiveWalkingResponse> getAllActiveWalkers(WalkerSearchRequest request) {
        List<Walking> allAnyDogSizeWalkings = walkingService.findAnyDogSizeWalkingsBy(request);
        List<Order> overlappingOrders = orderService.findOverlappingOrders(request);
        List<Walking> availableAnyDogSizeWalkings = getAvailableAnyDogSizeWalkings(allAnyDogSizeWalkings, overlappingOrders);
        List<Size> requiredSizes = getRequiredSizes(request.getDogInfos());
        List<Walking> availableWalkings = getAvailableWalkings(availableAnyDogSizeWalkings, requiredSizes);
        List<AllActiveWalkingResponse> responses = walkingMapper.toDtos(availableWalkings);
        return responses;
    }

    private static List<Walking> getAvailableAnyDogSizeWalkings(List<Walking> allAnyDogSizeWalkings, List<Order> overlappingOrders) {
        List<Walking> availableAnyDogSizeWalkings = new ArrayList<>();
        for (Walking walking : allAnyDogSizeWalkings) {
            boolean includeToAvailable = true;
            for (Order order : overlappingOrders) {
                if (order.getWalking().equals(walking)) {
                    includeToAvailable = false;
                    break;
                }
            }
            if (includeToAvailable) {
                availableAnyDogSizeWalkings.add(walking);
            }
        }
        return availableAnyDogSizeWalkings;
    }

    private List<Size> getRequiredSizes(List<DogInfo> dogInfos) {
        List<Size> requiredSizes = new ArrayList<>();
        for (DogInfo dogInfo : dogInfos) {
            if (dogInfo.getIsSelected()) {
                Dog dog = dogService.findById(dogInfo.getDogId());
                Size size = dog.getSize();
                if (!requiredSizes.contains(size)) {
                    requiredSizes.add(size);
                }
            }
        }
        return requiredSizes;
    }

    private List<Walking> getAvailableWalkings(List<Walking> availableAnyDogSizeWalkings, List<Size> requiredSizes) {
        List<Walking> availableWalkings = new ArrayList<>();
        for (Walking walking : availableAnyDogSizeWalkings) {
            boolean addToAvailable = true;
            for (Size requiredSize : requiredSizes) {
                List<Size> walkingSizes = walkingSizeService.findSizesBy(walking);
                if (!walkingSizes.contains(requiredSize)) {
                    addToAvailable = false;
                    break;
                }
            }

            if (addToAvailable) {
                availableWalkings.add(walking);
            }

        }
        return availableWalkings;
    }

    private void createWalkingSize(WalkingRequest request, Walking walking) {
        List<DogSizeDto> sizes = request.getSizes();
        for (DogSizeDto size : sizes) {
            if (size.getIsSelected()) {
                Integer sizeId = size.getSizeId();
                Size sizeFromEntity = sizeService.findById(sizeId);
                WalkingSize walkingSize = new WalkingSize();
                walkingSize.setWalking(walking);
                walkingSize.setSize(sizeFromEntity);
                walkingSizeService.addWalkingSize(walkingSize);
            }
        }
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

}
