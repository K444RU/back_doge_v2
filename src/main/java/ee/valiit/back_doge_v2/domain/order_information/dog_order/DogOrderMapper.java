package ee.valiit.back_doge_v2.domain.order_information.dog_order;

import ee.valiit.back_doge_v2.business.dog.dto.OrderedDog;
import ee.valiit.back_doge_v2.business.order.dto.WalkerActiveOrderResponse;
import org.mapstruct.*;

import java.time.LocalDate;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DogOrderMapper {


}
