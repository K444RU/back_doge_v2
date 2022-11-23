package ee.valiit.back_doge_v2.domain.dog_information.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Picture} entity
 */
@Data
public class PictureDto implements Serializable {
    private final Integer id;
    private final byte[] data;
}