package ee.valiit.back_doge_v2.business.user.dtos;

import lombok.Data;

@Data
public class OwnerPictureRequest {
    private Integer userId;
    private String photoData;
}
