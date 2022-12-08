package ee.valiit.back_doge_v2.domain.order_information.order;

import ee.valiit.back_doge_v2.business.dog.dto.WalkerSearchRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalTime;
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

    public List<Order> findOverlappingOrders(WalkerSearchRequest request) {
        LocalTime timeFrom = LocalTime.of(request.getTimeFrom(), 0).plusMinutes(1);
        LocalTime timeTo = LocalTime.of(request.getTimeTo(), 0).minusMinutes(1);
        return orderRepository.findOverlappingOrders("A", request.getDate(), timeFrom, timeTo);
    }
}
