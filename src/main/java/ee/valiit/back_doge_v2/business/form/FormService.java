package ee.valiit.back_doge_v2.business.form;

import ee.valiit.back_doge_v2.business.form.dto.CityDto;
import ee.valiit.back_doge_v2.business.form.dto.DogBreedDto;
import ee.valiit.back_doge_v2.business.form.dto.DogSizeDto;
import ee.valiit.back_doge_v2.domain.dog_information.breed.Breed;
import ee.valiit.back_doge_v2.domain.dog_information.breed.BreedMapper;
import ee.valiit.back_doge_v2.domain.dog_information.breed.BreedService;
import ee.valiit.back_doge_v2.domain.dog_information.size.Size;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeMapper;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeService;
import ee.valiit.back_doge_v2.domain.order_information.city.City;
import ee.valiit.back_doge_v2.domain.order_information.city.CityMapper;
import ee.valiit.back_doge_v2.domain.order_information.city.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FormService {


    @Resource
    private BreedService breedService;

    @Resource
    private CityService cityService;

    @Resource
    private SizeService sizeService;

    @Resource
    private BreedMapper breedMapper;

    @Resource
    private CityMapper cityMapper;

    @Resource
    private SizeMapper sizeMapper;

    public List<DogSizeDto> getAllSizes() {
        List<Size> allEntities = sizeService.findAllSizes();
        return sizeMapper.sizeToSizeDto(allEntities);
    }

    public List<DogBreedDto> getAllBreeds() {
        List<Breed> breeds = breedService.findAllBreeds();
        return breedMapper.breedToBreedDto(breeds);
    }

    public List<CityDto> getAllCities() {
        List<City> allCities = cityService.findAllCities();
        return cityMapper.cityToCityDto(allCities);
    }

}
