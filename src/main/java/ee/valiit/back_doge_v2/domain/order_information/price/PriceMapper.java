package ee.valiit.back_doge_v2.domain.order_information.price;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PriceMapper {
    Price priceDtoToPrice(PriceDto priceDto);

    PriceDto priceToPriceDto(Price price);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Price updatePriceFromPriceDto(PriceDto priceDto, @MappingTarget Price price);
}
