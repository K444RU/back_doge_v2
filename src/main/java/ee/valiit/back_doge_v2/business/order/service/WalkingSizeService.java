package ee.valiit.back_doge_v2.business.order.service;

import ee.valiit.back_doge_v2.domain.dog_information.size.Size;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSize;
import ee.valiit.back_doge_v2.domain.order_information.walking_size.WalkingSizeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WalkingSizeService {

    @Resource
    private WalkingSizeRepository walkingSizeRepository;




    public void addWalkingSize(WalkingSize walkingSize) {
        walkingSizeRepository.save(walkingSize);
    }

    public List<Size> findSizeBy(Integer walkingId){
        List<Size> sizes = walkingSizeRepository.findSizeTypeByWalkingId(walkingId);
        return sizes;

//    public void addSizeTypeToSizeDto(WalkingResponse sizes) {
//        List<WalkingSize> sizeTypeByWalkingId = walkingSizeRepository.findSizeTypeByWalkingId(sizes.getWalkingId());

//        List<SizeDtoToWalkingResponse> sizeDtoToWalkingResponses = walkingSizeMapper.fromEntityToSizeDtoToWalkingResponse(sizeTypeByWalkingId);
//        sizes.setSizeType(sizeDtoToWalkingResponses);
    }


}
