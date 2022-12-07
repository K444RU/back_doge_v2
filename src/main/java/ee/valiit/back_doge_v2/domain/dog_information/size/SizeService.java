package ee.valiit.back_doge_v2.domain.dog_information.size;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class SizeService {
    @Resource
    private SizeRepository sizeRepository;

    public List<Size> findAllSizes() {
        return sizeRepository.findAll();
    }

    public Size getValidSize(Integer dogSizeId) {
        Optional<Size> optionalSize = sizeRepository.findById(dogSizeId);
        return optionalSize.get();
    }

    public Size findById(Integer sizeId) {
        return sizeRepository.findById(sizeId).get();
    }

}
