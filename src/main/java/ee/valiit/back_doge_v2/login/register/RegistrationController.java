package ee.valiit.back_doge_v2.login.register;

import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleDto;
import ee.valiit.back_doge_v2.login.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Resource
    private RegistrationService registrationService;


    @GetMapping("/role")
    @Operation(summary = "Väljastab kõik rollid")
    public List<RoleDto> getAllRoles() {
        List<RoleDto> roles = registrationService.getAllRoles();
        return roles;
    }


    @PostMapping()
    @Operation(summary = "Uue kasutaja registreerimine")
    public LoginResponse addNewUser(@RequestBody NewUserRequest request) {
        return registrationService.addNewUser(request);
    }


}
