package ee.valiit.back_doge_v2.business.register;

import ee.valiit.back_doge_v2.business.login.dto.LoginResponse;
import ee.valiit.back_doge_v2.business.register.dto.NewUserRequest;
import ee.valiit.back_doge_v2.business.register.service.UserRegistrationService;
import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("")
public class RegistrationController {

    @Resource
    private UserRegistrationService registrationService;

    @PostMapping("/register")
    @Operation(summary = "Post user information (new user register)")
    public LoginResponse addNewUser(@RequestBody NewUserRequest request) {
        return registrationService.addNewUser(request);
    }

    @GetMapping("/register/role")
    @Operation(summary = "Get all roles")
    public List<RoleDto> getAllRoles() {
        List<RoleDto> roles = registrationService.getAllRoles();
        return roles;
    }
}
