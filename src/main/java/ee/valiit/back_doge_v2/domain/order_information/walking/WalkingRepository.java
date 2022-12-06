package ee.valiit.back_doge_v2.domain.order_information.walking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WalkingRepository extends JpaRepository<Walking, Integer> {

    @Query("select w from Walking w where w.user.id = ?1 and w.status = ?2")
    List<Walking> findWalkingByUserId(Integer id, String status);








}