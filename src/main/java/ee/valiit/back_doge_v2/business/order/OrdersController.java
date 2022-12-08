package ee.valiit.back_doge_v2.business.order;

import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkerActiveOrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    @PostMapping("/walking/order")
    @Operation(summary = "Post new order")
    public void addNewOrder(@RequestBody OrderRequest request) {
        ordersService.addNewOrder(request);
    }

    @GetMapping("/walking/order")
    @Operation(summary = "Get walker all active Orders by userId (walker user id)")
    public List<WalkerActiveOrderResponse> getWalkerActiveOrders(@RequestParam Integer userId) {
     return ordersService.getWalkerActiveOrders(userId);
    }

}

