package ee.valiit.back_doge_v2.domain.order_information.walking_size;

import ee.valiit.back_doge_v2.domain.dog_information.size.Size;
import ee.valiit.back_doge_v2.domain.order_information.walking.Walking;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class WalkingSizeService {

    @Resource
    private WalkingSizeRepository walkingSizeRepository;

    public void addWalkingSize(WalkingSize walkingSize) {
        walkingSizeRepository.save(walkingSize);
    }

    public List<Size> findSizeBy(Integer walkingId) {
        List<WalkingSize> walkingSizes = walkingSizeRepository.findSizeTypeByWalkingId(walkingId);
        List<Size> sizes = new ArrayList<>();
        for (WalkingSize walkingSize : walkingSizes) {
            sizes.add(walkingSize.getSize());
        }
        return sizes;
    }

    public List<Size> findSizesBy(Walking walking) {
        return walkingSizeRepository.findSizesBy(walking);
    }
}
