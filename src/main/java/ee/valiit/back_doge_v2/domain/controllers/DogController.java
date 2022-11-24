package ee.valiit.back_doge_v2.domain.controllers;

import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {

    @Resource
    private DogService dogService;


    @GetMapping("/bread")
    @Operation(summary = "Kuvab kõike koerte tõuge")
    public List <BreedDto> getAllBreeds() {
        List<BreedDto> breeds = dogService.getAllBreeds();
        return breeds;
    }


}
