package ee.valiit.back_doge_v2.business.dog;

import ee.valiit.back_doge_v2.business.dog.dto.*;
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
@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Tagastab dog informatsiooni, kus sees on olemas kasutaia 'dogName', 'dogAge', 'dogBreed' ja 'dogSizeType'"), @ApiResponse(responseCode = "400", description = "Vale dog ID", content = @Content(schema = @Schema(implementation = ApiError.class)))})
public class DogsController {

    @Resource
    private DogsService dogsService;

    @PostMapping("/registration")
    @Operation(summary = "Post dog information (new dog register)")
    public void addNewDog(@RequestBody DogRegistrationRequest request) {
        dogsService.addNewDog(request);
    }

    @GetMapping("/size")
    @Operation(summary = "Get all gog sizes")
    public List<DogSizeDto> getAllSizes() {
        return dogsService.getAllSizes();
    }

    @GetMapping("/bread")
    @Operation(summary = "Get all dog breeds")
    public List<DogBreedDto> getAllBreeds() {
        return dogsService.getAllBreeds();
    }

    @GetMapping("/info")
    @Operation(summary = "Get owner all dogs and every dog information by userId and status('A')")
    public List<OwnerHomePageDogInfoResponse> getDogInfoByUserId(@RequestParam Integer userId) {
        List<OwnerHomePageDogInfoResponse> dogInfoByUserId = dogsService.getDogInfoByUserId(userId);
        return dogInfoByUserId;
    }

    @GetMapping("/select")
    @Operation(summary = "Get dogName and dogId by userId")
    public List<DogInfo> getDogNameByUserId(@RequestParam Integer userId) {
        List<DogInfo> dogNameDropdownByUserId = dogsService.getDogNameByUserId(userId);
        return dogNameDropdownByUserId;
    }

    @PutMapping()
    @Operation(summary = "Update dogStatus by dogId (Change status to 'I')")
    public void updateDogStatus(@RequestParam Integer dogId, @RequestBody DogStatusUpdate request) {
        dogsService.updateDogStatus(dogId, request);
    }

}
