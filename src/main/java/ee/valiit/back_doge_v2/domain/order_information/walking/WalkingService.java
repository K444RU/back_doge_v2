package ee.valiit.back_doge_v2.domain.order_information.walking;

import ee.valiit.back_doge_v2.business.dog.dto.WalkerSearchRequest;
import ee.valiit.back_doge_v2.business.order.dto.AllActiveWalkingResponse;
import ee.valiit.back_doge_v2.business.order.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkingResponse;
import ee.valiit.back_doge_v2.business.order.service.OrderService;
import ee.valiit.back_doge_v2.business.order.service.WalkingSizeService;
import ee.valiit.back_doge_v2.business.user.service.UserService;
import ee.valiit.back_doge_v2.domain.dog_information.size.Size;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeDto;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeMapper;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeRepository;
import ee.valiit.back_doge_v2.domain.order_information.city.City;
import ee.valiit.back_doge_v2.domain.order_information.city.CityRepository;
import ee.valiit.back_doge_v2.domain.order_information.order.Order;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSize;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSizeDto;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSizeMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import org.apache.tomcat.jni.OS;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private OrderService orderService;

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

    public List<AllActiveWalkingResponse> getAllActiveWalkers(WalkerSearchRequest request) {
        List<Walking> walkings = walkingRepository.findWalkingsBy(request.getCityId(), request.getDate(),  "A");
        Integer timeFrom = request.getTimeFrom();
        Integer timeTo = request.getTimeTo();
        List<Integer> requiredHours = getHoursBetween(timeFrom, timeTo);


        List<Walking> availableWalkings = new ArrayList<>();

        for (Walking walking : walkings) {
            List<Integer> walkerHours = getHoursBetween(walking.getTimeFrom(), walking.getTimeTo());
            List<Order> orders = orderService.findOrdersBy(walking.getId(), request.getDate());
            List<Integer> allBookedHours = new ArrayList<>();
            for (Order order : orders) {
                List<Integer> bookedHours = getHoursBetween(order.getTimeFrom(), order.getTimeTo());
                allBookedHours.addAll(bookedHours);
            }

            List<Integer> availableWalkerHours = new ArrayList<>();




            for (Integer walkerHour : walkerHours) {
                if (!allBookedHours.contains(walkerHour)) {
                    availableWalkerHours.add(walkerHour);
                }


            }
        }



        return null;
    }


    private static List<Integer> getHoursBetween(Integer timeFrom, Integer timeTo) {
        List<Integer> requiredHours = new ArrayList<>();
        for (int hour = timeFrom; hour < timeTo; hour++) {
            requiredHours.add(hour);
        }
        return requiredHours;
    }
}
