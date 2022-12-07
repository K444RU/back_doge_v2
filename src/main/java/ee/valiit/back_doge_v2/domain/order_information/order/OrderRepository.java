package ee.valiit.back_doge_v2.domain.order_information.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.walking.id = ?1 and o.walkingDate = ?2")
    List<Order> findOrdersBy(Integer walkingId, LocalDate walkingDate);

}