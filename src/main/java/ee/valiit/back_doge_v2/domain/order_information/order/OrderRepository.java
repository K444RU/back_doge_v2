package ee.valiit.back_doge_v2.domain.order_information.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.walking.id = ?1 and o.walkingDate = ?2")
    List<Order> findOrdersBy(Integer walkingId, LocalDate walkingDate);

    @Query("""
            select o
            from Order o
            where o.status = ?1
                and (o.walkingDate = ?2)
                and ((?3 between o.timeFrom and o.timeTo)
                or (?4 between o.timeFrom and o.timeTo))""")
    List<Order> findOverlappingOrders(String status, LocalDate walkingDate, LocalTime timeFrom, LocalTime timeTo);

    @Query("select o from Order o where o.walking.id = ?1")
    List<Order> findByWalkingId(Integer id);

    @Query("select o from Order o where o.walking.user.id = ?1 order by o.walkingDate")
    List<Order> findBy(Integer id);



}
