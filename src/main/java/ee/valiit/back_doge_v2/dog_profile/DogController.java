package ee.valiit.back_doge_v2.dog_profile;

import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {

    @Resource
    private DogService dogService;


    @GetMapping("/bread")
    @Operation(summary = "väljastab kõike koerte tõuge")
    public List<BreedDto> getAllBreeds() {
        List<BreedDto> breeds = dogService.getAllBreeds();
        return breeds;
    }

    @GetMapping("/size")
    @Operation(summary = "Väljastab kõikide koerte suurused")
    public List<SizeDto> getAllSizes() {
        List<SizeDto> sizes = dogService.getAllSizes();
        return sizes;
    }

    @PostMapping("/registration")
    @Operation(summary = "Uue koera registreerimine")
    public void addNewDog(@RequestBody DogRequest request) {
        System.out.println();
        dogService.addNewDog(request);
    }


}
