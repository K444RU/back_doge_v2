package ee.valiit.back_doge_v2.business.dog.dto;

import lombok.Data;

@Data
public class DogInfo {
    private Integer dogId;
    private String dogName;
    private Boolean isSelected = false;
}
