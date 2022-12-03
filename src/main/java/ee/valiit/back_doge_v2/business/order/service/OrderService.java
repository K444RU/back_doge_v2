package ee.valiit.back_doge_v2.business.order.service;


import ee.valiit.back_doge_v2.domain.order_information.city.City;
import ee.valiit.back_doge_v2.domain.order_information.city.CityDto;
import ee.valiit.back_doge_v2.domain.order_information.city.CityMapper;
import ee.valiit.back_doge_v2.domain.order_information.city.CityRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private CityMapper cityMapper;

    @Resource
    private CityRepository cityRepository;


    public  List<CityDto> getAllCities(){
        List<City> allCities = cityRepository.findAll();
        List<CityDto> allCitiesDto = cityMapper.cityToCityDto(allCities);
        return allCitiesDto;
    }


}
