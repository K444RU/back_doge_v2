package ee.valiit.back_doge_v2.business.walker;

import ee.valiit.back_doge_v2.business.dog.dto.CityDto;
import ee.valiit.back_doge_v2.business.dog.dto.WalkerSearchRequest;
import ee.valiit.back_doge_v2.business.order.dto.AllActiveWalkingResponse;
import ee.valiit.back_doge_v2.business.order.dto.WalkingRequest;
import ee.valiit.back_doge_v2.business.order.dto.WalkingResponse;
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

    @GetMapping("/walking/city")
    @Operation(summary = "Get all city list")
    public List<CityDto> getAllCities() {
        return walkerService.getAllCities();
    }

    @GetMapping("/walking")
    @Operation(summary = "Get all walkings by userId and status 'A'")
    public List<WalkingResponse> getUserAllWalkingsByUserId(@RequestParam Integer userId) {
        return walkerService.getUserAllWalkingsByUserId(userId);
    }

    @PostMapping("/walking")
    @Operation(summary = "Get walkings by cityId && date && timeFrom && timeTo && dogSize && status 'A' ")
    public List<AllActiveWalkingResponse> getAllActiveWalkers(@RequestBody WalkerSearchRequest request) {
        return walkerService.getAllActiveWalkers(request);
    }

}