package ee.valiit.back_doge_v2.domain.order_information.walking_size;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalkingSizeRepository extends JpaRepository<WalkingSize, Integer> {
    List<WalkingSize> findWalkingByUserId(Integer id);

}