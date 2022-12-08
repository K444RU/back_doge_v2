package ee.valiit.back_doge_v2.business.dog;

import ee.valiit.back_doge_v2.business.dog.dto.*;
import ee.valiit.back_doge_v2.business.order.dto.OwnerActiveOrdersResponse;
import ee.valiit.back_doge_v2.business.user.UsersService;
import ee.valiit.back_doge_v2.domain.dog_information.breed.Breed;
import ee.valiit.back_doge_v2.domain.dog_information.breed.BreedService;
import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogMapper;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogService;
import ee.valiit.back_doge_v2.domain.dog_information.size.Size;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeService;
import ee.valiit.back_doge_v2.domain.order_information.dog_order.DogOrderService;
import ee.valiit.back_doge_v2.domain.order_information.order.Order;
import ee.valiit.back_doge_v2.domain.order_information.order.OrderMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DogsService {

    @Resource
    private BreedService breedService;

    @Resource
    private DogService dogService;

    @Resource
    private UsersService usersService;

    @Resource
    private SizeService sizeService;

    @Resource
    private DogMapper dogMapper;
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private DogOrderService dogOrderService;

    public List<OwnerHomePageDogInfoResponse> getDogInfoByUserId(Integer userId) {
        List<Dog> dogsByUserId = dogService.findDogsByUserId(userId, "A");
        return dogMapper.ownerHomePageDogsInfoResponse(dogsByUserId);

    }

    public List<DogInfo> getDogNameByUserId(Integer userId) {
        List<Dog> dogsByUserId = dogService.findDogsByUserId(userId, "A");
        return dogMapper.dogsNamesDropdownByUserId(dogsByUserId);
    }


    public void updateDogStatus(DogStatusUpdate request) {
        Dog dog = dogService.findById(request.getDogId());
        dogMapper.updateDogStatus(request, dog);
        dogService.save(dog);
    }

    public void addNewDog(DogRegistrationRequest request) {
        User validUser = usersService.getUserById(request.getUserId());
        Breed validBreed = breedService.getValidBreed(request.getBreedId());
        Size validSize = sizeService.getValidSize(request.getSizeId());
        Dog dog = dogMapper.dogRequestToDog(request);
        dog.setUser(validUser);
        dog.setBreed(validBreed);
        dog.setSize(validSize);
        dogService.save(dog);
    }

    public List<OwnerActiveOrdersResponse> getDogActiveOrders(Integer dogId) {
        List<Dog> dogs = dogService.findBy(dogId);
        List<OwnerActiveOrdersResponse> dogResponses = dogMapper.entityToOwnerResponses(dogs);
        addDogOrder(dogResponses);
        return dogResponses;
    }

    private void addDogOrder(List<OwnerActiveOrdersResponse> dogResponses) {
        for (OwnerActiveOrdersResponse dogResponse : dogResponses) {
            addOrderToResponse(dogResponse);
        }
    }

    private void addOrderToResponse(OwnerActiveOrdersResponse response) {
        List<Order> orders = dogOrderService.findOrdersByOrderId(response.getDogId());
        List<DogActiveOrders> ordersResponses = orderMapper.entityToOrderedDogsResponses(orders);
        response.setOrders(ordersResponses);


    }
}
