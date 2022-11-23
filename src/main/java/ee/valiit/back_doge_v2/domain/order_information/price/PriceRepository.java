package ee.valiit.back_doge_v2.domain.order_information.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

}