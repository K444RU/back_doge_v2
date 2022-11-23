package ee.valiit.back_doge_v2.domain.walker_information.size;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link Size} entity
 */
@Data
public class SizeDto implements Serializable {
    private final Integer id;
    @javax.validation.constraints.Size(max = 30)
    @NotNull
    private final String type;
    @NotNull
    private final Integer price;
}