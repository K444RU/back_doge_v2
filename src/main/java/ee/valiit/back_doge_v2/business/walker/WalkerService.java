package ee.valiit.back_doge_v2.business.walker;

import ee.valiit.back_doge_v2.business.form.dto.DogSizeDto;
import ee.valiit.back_doge_v2.business.dog.dto.WalkerSearchRequest;
import ee.valiit.back_doge_v2.business.dog.dto.WalkingSizeDto;
import ee.valiit.back_doge_v2.business.order.OrdersService;
import ee.valiit.back_doge_v2.business.walker.dto.AllActiveWalkingResponse;
import ee.valiit.back_doge_v2.business.walker.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.walker.dto.WalkingResponse;
import ee.valiit.back_doge_v2.business.user.UsersService;
import ee.valiit.back_doge_v2.domain.dog_information.size.Size;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeMapper;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeService;
import ee.valiit.back_doge_v2.domain.order_information.city.City;
import ee.valiit.back_doge_v2.domain.order_information.city.CityService;
import ee.valiit.back_doge_v2.domain.order_information.order.Order;
import ee.valiit.back_doge_v2.domain.order_information.walking.Walking;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingMapper;
import ee.valiit.back_doge_v2.domain.order_information.walking.WalkingService;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSize;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSizeService;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class WalkerService {

    @Resource
    private CityService cityService;

    @Resource
    private OrdersService ordersService;

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
        walking.setUser(user);
        walking.setCity(city);
        walkingService.save(walking);
        createWalkingSize(request, walking);
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

    public List<WalkingResponse> getUserAllWalkingsByUserId(Integer userId) {
        List<Walking> walkings = walkingService.findWalkingByUserId(userId, "A");
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
        List<Walking> walkings = walkingService.findWalkingsBy(request.getCityId(), request.getDate(), "A");
        Integer timeFrom = request.getTimeFrom();
        Integer timeTo = request.getTimeTo();
        List<Integer> requiredHours = getHoursBetween(timeFrom, timeTo);


        List<Walking> availableWalkings = new ArrayList<>();

        for (Walking walking : walkings) {
            List<Integer> walkerHours = getHoursBetween(null, null);
            List<Order> orders = ordersService.findOrdersBy(walking.getId(), request.getDate());
            List<Integer> allBookedHours = new ArrayList<>();
            for (Order order : orders) {
                List<Integer> bookedHours = getHoursBetween(null, null);
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
