package ee.valiit.back_doge_v2.domain.order_information.walking_size;

import ee.valiit.back_doge_v2.domain.dog_information.size.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WalkingSizeRepository extends JpaRepository<WalkingSize, Integer> {

    @Query("select w from WalkingSize w where w.walking.user.id = ?1")
    List<WalkingSize> findWalkingByUserId(Integer id);

    @Query("""
            select w from WalkingSize w
            where w.walking.id = ?1
            order by w.walking.id, w.walking.dateFrom, w.walking.dateTo""")
    List<WalkingSize> findSizeTypeByWalkingId(Integer walkingId);



}