package ee.valiit.back_doge_v2.domain.order_information.walking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface WalkingRepository extends JpaRepository<Walking, Integer> {

    @Query("select w from Walking w where w.user.id = ?1 and w.status = ?2")
    List<Walking> findWalkingByUserId(Integer id, String status);

    @Query("""
            select w from Walking w
            where w.city.id = ?1 and ?2 between w.dateFrom and w.dateTo and w.status = ?3
            order by w.user.contact.firstname""")
    List<Walking> findWalkingsBy(Integer cityId, LocalDate date, String status);

    @Query("""
            select w
            from Walking w
            where w.city.id = ?1
              and w.status = ?2
              and (?3 between w.dateFrom and w.dateTo)
              and (?4 between w.timeFrom and w.timeTo)
              and (?5 between w.timeFrom and w.timeTo)""")
    List<Walking> findWalkingsBy(Integer cityId, String status, LocalDate walkingDate, LocalTime timeFrom, LocalTime timeTo);
}