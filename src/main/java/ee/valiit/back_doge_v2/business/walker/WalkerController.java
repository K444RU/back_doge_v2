package ee.valiit.back_doge_v2.business.walker;

import ee.valiit.back_doge_v2.business.dog.dto.WalkerSearchRequest;
import ee.valiit.back_doge_v2.business.walker.dto.AllActiveWalkingResponse;
import ee.valiit.back_doge_v2.business.walker.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.walker.dto.WalkingResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class WalkerController {

    @Resource
    private WalkerService walkerService;

    @PostMapping("/walking/register")
    @Operation(summary = "Post new walking")
    public void addNewWalking(@RequestBody WalkingRequest request) {
        walkerService.addNewWalking(request);
    }

    @GetMapping("/walking")
    @Operation(summary = "Get all walkings by userId and status 'A'")
    public List<WalkingResponse> getUserAllWalkingsByUserId(@RequestParam Integer userId) {
        return walkerService.getUserAllWalkingsByUserId(userId);
    }

    @PostMapping("/walking")
    @Operation(summary = "Get all active walkings by cityId && date && timeFrom && timeTo && dogSize && status 'A' ")
    public List<AllActiveWalkingResponse> getAllActiveWalkers(@RequestBody WalkerSearchRequest request) {
        return walkerService.getAllActiveWalkers(request);
    }

    @DeleteMapping("/walking/delete")
    @Operation(summary = "Delete walking by walkingId")
    public void getAllActiveWalkers(@RequestParam Integer walkingId) {
        walkerService.deleteWalking(walkingId);
    }

}