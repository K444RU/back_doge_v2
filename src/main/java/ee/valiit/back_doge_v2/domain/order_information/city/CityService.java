package ee.valiit.back_doge_v2.domain.order_information.city;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    public City findById(Integer cityId) {
        return cityRepository.findById(cityId).get();
    }

}
