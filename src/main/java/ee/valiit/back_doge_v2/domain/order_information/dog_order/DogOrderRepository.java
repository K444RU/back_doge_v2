package ee.valiit.back_doge_v2.domain.order_information.dog_order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogOrderRepository extends JpaRepository<DogOrder, Integer> {
}