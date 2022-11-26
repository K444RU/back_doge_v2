package ee.valiit.back_doge_v2.domain.controllers;

import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.domain.walker_information.size.SizeDto;
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
    @Operation(summary = "väljastab kõike koerte tõuge")
    public List <BreedDto> getAllBreeds() {
        List<BreedDto> breeds = dogService.getAllBreeds();
        return breeds;
    }

    @GetMapping("/size")
    @Operation(summary = "Väljastab kõikide koerte suurused")
    public List<SizeDto> getAllSizes() {
        List<SizeDto> sizes =dogService.getAllSizes();
        return sizes;
    }





}
