package ee.valiit.back_doge_v2.domain.order_information.dog_order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogOrderRepository extends JpaRepository<DogOrder, Integer> {
    @Query("select d from DogOrder d where d.order.walking.user.id = ?1")
    List<DogOrder> findBy(Integer userId);

    @Query("select d from DogOrder d where d.order.id = ?1 order by d.dog.name")
    List<DogOrder> findDogNameByOrderId(Integer id);

    @Query("select d from DogOrder d where d.dog.id = ?1")
    List<DogOrder> findByDogId(Integer dogId);

    @Query("select d from DogOrder d where d.dog.id = ?1 and d.order.status = ?2")
    List<DogOrder> findByDogId(Integer id, String status);






}