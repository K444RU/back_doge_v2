package ee.valiit.back_doge_v2.business.order;

import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.order.service.OrderService;
import ee.valiit.back_doge_v2.business.order.service.WalkingRegistrationService;
import ee.valiit.back_doge_v2.domain.order_information.city.CityDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/walking")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private WalkingRegistrationService walkingRegistrationService;




    @GetMapping("/city")
    @Operation(summary = "Appear the list of All cities")
    public List<CityDto> getAllCities(){
        List<CityDto> cities = orderService.getAllCities();
        return cities;
    }

    @PostMapping("/register")
    @Operation(summary = "Post walking information")
    public void addNewWalking(@RequestBody WalkingRequest request){
        walkingRegistrationService.addNewWalking(request);
    }

//    @PostMapping("/order")
//    @Operation(summary = "Post order information")
//    public void addNewOrder(@RequestBody OrderRequest request){
//        orderService.addNewOrder(request);
//    }








}
