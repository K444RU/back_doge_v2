package ee.valiit.back_doge_v2.business.form;

import ee.valiit.back_doge_v2.business.form.dto.CityDto;
import ee.valiit.back_doge_v2.business.form.dto.DogBreedDto;
import ee.valiit.back_doge_v2.business.form.dto.DogSizeDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class FormController {

    @Resource
    private FormService formService;

    @GetMapping("/dog/size")
    @Operation(summary = "Get all gog sizes")
    public List<DogSizeDto> getAllSizes() {
        return formService.getAllSizes();
    }

    @GetMapping("/dog/bread")
    @Operation(summary = "Get all dog breeds")
    public List<DogBreedDto> getAllBreeds() {
        return formService.getAllBreeds();
    }

    @GetMapping("/walking/city")
    @Operation(summary = "Get all city list")
    public List<CityDto> getAllCities() {
        return formService.getAllCities();
    }

}
