package ee.valiit.back_doge_v2.business.register;

import ee.valiit.back_doge_v2.business.register.dtos.DogRegistrationRequest;
import ee.valiit.back_doge_v2.business.register.dtos.NewUserRequest;
import ee.valiit.back_doge_v2.business.register.services.DogRegistrationService;
import ee.valiit.back_doge_v2.business.register.services.UserRegistrationService;
import ee.valiit.back_doge_v2.domain.dog_information.breeds.BreedDto;
import ee.valiit.back_doge_v2.domain.dog_information.size.SizeDto;
import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleDto;
import ee.valiit.back_doge_v2.business.login.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("")
public class RegistrationController {

    @Resource
    private UserRegistrationService registrationService;
    @Resource
    private DogRegistrationService dogRegistrationService;

    @PostMapping("/register")
    @Operation(summary = "Post user information (new user register)")
    public LoginResponse addNewUser(@RequestBody NewUserRequest request) {
        return registrationService.addNewUser(request);
    }

    @GetMapping("/register/role")
    @Operation(summary = "get all roles")
    public List<RoleDto> getAllRoles() {
        List<RoleDto> roles = registrationService.getAllRoles();
        return roles;
    }

    @PostMapping("/dog/registration")
    @Operation(summary = "Post dog information (new dog register)")
    public void addNewDog(@RequestBody DogRegistrationRequest request) {
        System.out.println();
        dogRegistrationService.addNewDog(request);
    }

    @GetMapping("/dog/size")
    @Operation(summary = "Get all gog izes")
    public List<SizeDto> getAllSizes() {
        List<SizeDto> sizes = dogRegistrationService.getAllSizes();
        return sizes;
    }

    @GetMapping("/dog/bread")
    @Operation(summary = "Get all dog breeds")
    public List<BreedDto> getAllBreeds() {
        List<BreedDto> breeds = dogRegistrationService.getAllBreeds();
        return breeds;
    }
}
