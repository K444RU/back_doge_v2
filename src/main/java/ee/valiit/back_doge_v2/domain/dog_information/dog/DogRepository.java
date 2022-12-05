package ee.valiit.back_doge_v2.domain.dog_information.dog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {
    Optional<Dog> findDogByUserId(Integer id);
    List<Dog> findDogsByUserId(Integer id);







}