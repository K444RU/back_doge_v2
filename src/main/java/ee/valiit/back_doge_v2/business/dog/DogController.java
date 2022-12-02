package ee.valiit.back_doge_v2.business.dog;

import ee.valiit.back_doge_v2.business.dog.dto.DogRegistrationRequest;
import ee.valiit.back_doge_v2.business.dog.dto.OwnerHomePageDogInfoResponse;
import ee.valiit.back_doge_v2.business.dog.service.*;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeDto;
import ee.valiit.back_doge_v2.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dog")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tagastab dog informatsiooni, kus sees on olemas kasutaia 'dogName', 'dogAge', 'dogBreed' ja 'dogSizeType'"),
        @ApiResponse(responseCode = "400", description = "Vale dog ID", content = @Content(schema = @Schema(implementation = ApiError.class)))
})
public class DogController {

    @Resource
    private DogService dogService;

    @Resource
    private DogRegistrationService dogRegistrationService;

    @PostMapping("/registration")
    @Operation(summary = "Post dog information (new dog register)")
    public void addNewDog(@RequestBody DogRegistrationRequest request) {
        System.out.println();
        dogRegistrationService.addNewDog(request);
    }

    @GetMapping("/size")
    @Operation(summary = "Get all gog izes")
    public List<SizeDto> getAllSizes() {
        List<SizeDto> sizes = dogRegistrationService.getAllSizes();
        return sizes;
    }

    @GetMapping("/bread")
    @Operation(summary = "Get all dog breeds")
    public List<BreedDto> getAllBreeds() {
        List<BreedDto> breeds = dogRegistrationService.getAllBreeds();
        return breeds;
    }

    @GetMapping("/info")
    @Operation(summary = "Get dog information by userId")
    public OwnerHomePageDogInfoResponse getDogInfoByUserId(@RequestParam Integer userId){
        OwnerHomePageDogInfoResponse dogInfoByUserId = dogService.getDogInfoByUserId(userId);
        return dogInfoByUserId;
    }
}
