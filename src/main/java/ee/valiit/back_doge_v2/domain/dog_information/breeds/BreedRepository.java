package ee.valiit.back_doge_v2.domain.dog_information.breeds;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BreedRepository extends JpaRepository<Breed, Integer> {
    Optional<Breed> findById(Integer dogBreedId);
}