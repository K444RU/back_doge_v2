package ee.valiit.back_doge_v2.business.dog;

import ee.valiit.back_doge_v2.business.dog.dto.DogInfo;
import ee.valiit.back_doge_v2.business.dog.dto.DogRegistrationRequest;
import ee.valiit.back_doge_v2.business.dog.dto.DogStatusUpdate;
import ee.valiit.back_doge_v2.business.dog.dto.OwnerHomePageDogInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DogsController {

    @Resource
    private DogsService dogsService;

    @PostMapping("/dog/registration")
    @Operation(summary = "Post dog information (new dog register)")
    public void addNewDog(@RequestBody DogRegistrationRequest request) {
        dogsService.addNewDog(request);
    }

    @GetMapping("/dog/info")
    @Operation(summary = "Get owner all dogs and every dog information by userId and status('A')")
    public List<OwnerHomePageDogInfoResponse> getDogInfoByUserId(@RequestParam Integer userId) {
        List<OwnerHomePageDogInfoResponse> dogInfoByUserId = dogsService.getDogInfoByUserId(userId);
        return dogInfoByUserId;
    }

    @GetMapping("/dog/select")
    @Operation(summary = "Get dogName and dogId by userId")
    public List<DogInfo> getDogNameByUserId(@RequestParam Integer userId) {
        List<DogInfo> dogNameDropdownByUserId = dogsService.getDogNameByUserId(userId);
        return dogNameDropdownByUserId;
    }

    @PutMapping("/dog")
    @Operation(summary = "Update dogStatus by dogId (Change status to 'I')")
    public void updateDogStatus(@RequestParam Integer dogId, @RequestBody DogStatusUpdate request) {
        dogsService.updateDogStatus(dogId, request);
    }

}
