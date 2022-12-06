package ee.valiit.back_doge_v2.business.order;

import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkingResponse;
import ee.valiit.back_doge_v2.business.order.service.OrderService;
import ee.valiit.back_doge_v2.business.order.service.WalkingService;
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
    private WalkingService walkingService;


    @GetMapping("/city")
    @Operation(summary = "Get all city list")
    public List<CityDto> getAllCities() {
        return orderService.getAllCities();
    }

    @PostMapping("/register")
    @Operation(summary = "Post new walking")
    public void addNewWalking(@RequestBody WalkingRequest request) {
        walkingService.addNewWalking(request);
    }

    @PostMapping("/order")
    @Operation(summary = "Post new order")
    public void addNewOrder(@RequestBody OrderRequest request) {
        orderService.addNewOrder(request);
    }

//    @GetMapping("/get")
//    @Operation(summary = "TEST. Get all posted walkings by userId (walker user id)")
//    public List<WalkingResponse> getAllWalkingByUserId(@RequestParam Integer userId) {
//        return walkingService.getAllWalkingByUserId(userId);
//
//    }

    @GetMapping()
    @Operation(summary = "Get all walkings by userId (walker user id)")
    public List<WalkingResponse> getUserAllWalkingsByUserId(@RequestParam Integer userId) {
        return walkingService.getUserAllWalkingsByUserId(userId);
    }


}

