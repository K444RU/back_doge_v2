package ee.valiit.back_doge_v2.domain.order_information.walking_size;

import ee.valiit.back_doge_v2.domain.dog_information.size.Size;
import ee.valiit.back_doge_v2.domain.order_information.walking.Walking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WalkingSizeRepository extends JpaRepository<WalkingSize, Integer> {


    @Query("""
            select w from WalkingSize w
            where w.walking.id = ?1
            order by w.walking.id, w.walking.dateFrom, w.walking.dateTo""")
    List<WalkingSize> findSizeTypeByWalkingId(Integer walkingId);

    @Query("select w.size from WalkingSize w where w.walking = ?1")
    List<Size> findSizesBy(Walking walking);


}