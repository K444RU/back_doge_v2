package ee.valiit.back_doge_v2.domain.order_information.walking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface WalkingRepository extends JpaRepository<Walking, Integer> {

    @Query("select w from Walking w where w.user.id = ?1 and w.status = ?2")
    List<Walking> findWalkingByUserId(Integer id, String status);

    @Query("""
            select w from Walking w
            where w.city.id = ?1 and ?2 between w.dateFrom and w.dateTo and w.status = ?3
            order by w.user.contact.firstname""")
    List<Walking> findWalkingsBy(Integer cityId, LocalDate date, String status);










}