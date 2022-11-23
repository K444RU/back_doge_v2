package ee.valiit.back_doge_v2.domain.dog_information.dog_picture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogPictureRepository extends JpaRepository<DogPicture, Integer> {
}