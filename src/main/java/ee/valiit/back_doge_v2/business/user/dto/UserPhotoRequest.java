package ee.valiit.back_doge_v2.business.user.dto;

import lombok.Data;

@Data
public class UserPhotoRequest {
    private Integer userId;
    private String photoData;
}
