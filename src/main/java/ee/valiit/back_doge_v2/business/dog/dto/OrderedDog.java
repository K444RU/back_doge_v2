package ee.valiit.back_doge_v2.business.dog.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderedDog implements Serializable {
    private String dogName;
}
