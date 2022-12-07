package ee.valiit.back_doge_v2.business.order;

import ee.valiit.back_doge_v2.business.dog.dto.WalkerSearchRequest;
import ee.valiit.back_doge_v2.business.order.dto.AllActiveWalkingResponse;
import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkingResponse;
import ee.valiit.back_doge_v2.business.order.service.OrderService;
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

    @GetMapping("/city")
    @Operation(summary = "Get all city list")
    public List<CityDto> getAllCities() {
        return orderService.getAllCities();
    }

    @PostMapping("/register")
    @Operation(summary = "Post new walking")
    public void addNewWalking(@RequestBody WalkingRequest request) {
        orderService.addNewWalking(request);
    }

    @PostMapping("/order")
    @Operation(summary = "Post new order")
    public void addNewOrder(@RequestBody OrderRequest request) {
        orderService.addNewOrder(request);
    }

    @GetMapping()
    @Operation(summary = "Get all walkings by userId and status 'A'")
    public List<WalkingResponse> getUserAllWalkingsByUserId(@RequestParam Integer userId) {
        return orderService.getUserAllWalkingsByUserId(userId);
    }

    @PostMapping
    @Operation(summary = "Get walkings by cityId && date && timeFrom && timeTo && dogSize && status 'A' ")
    public List<AllActiveWalkingResponse> getAllActiveWalkers(@RequestBody WalkerSearchRequest request) {
        return orderService.getAllActiveWalkers(request);
    }



}

