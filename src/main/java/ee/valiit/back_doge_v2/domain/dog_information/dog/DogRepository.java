package ee.valiit.back_doge_v2.domain.dog_information.dog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {
    Optional<Dog> findDogByUserId(Integer id);


    @Query("select d from Dog d where d.user.id = ?1 and d.status = ?2")
    List<Dog> findDogsByUserId(Integer userId, String status);








}