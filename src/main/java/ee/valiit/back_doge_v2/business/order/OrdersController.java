package ee.valiit.back_doge_v2.business.order;

import ee.valiit.back_doge_v2.business.order.dto.OrderRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    @PostMapping("/walking/order")
    @Operation(summary = "Post new order")
    public void addNewOrder(@RequestBody OrderRequest request) {
        ordersService.addNewOrder(request);
    }

}

