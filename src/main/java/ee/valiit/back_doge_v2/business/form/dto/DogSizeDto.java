package ee.valiit.back_doge_v2.business.form.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DogSizeDto implements Serializable {
    private Integer sizeId;
    private String sizeType;
    private Boolean isSelected;
}