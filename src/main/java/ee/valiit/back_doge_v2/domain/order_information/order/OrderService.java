package ee.valiit.back_doge_v2.domain.order_information.order;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }

    public List<Order> findOrdersBy(Integer walkingId, LocalDate walkingDate) {
        return orderRepository.findOrdersBy(walkingId, walkingDate);
    }

    public void deleteOrderBy(Integer walkingId) {
        List<Order> orders = orderRepository.findByWalkingId(walkingId);
        orderRepository.deleteAll(orders);
    }
}
