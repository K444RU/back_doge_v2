package ee.valiit.back_doge_v2.user_profile;

import ee.valiit.back_doge_v2.login.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Resource
    private RegistrationService registrationService;


    @PostMapping()
    @Operation(summary = "Uue kasutaja registreerimine")
    public LoginResponse addNewUser(@RequestBody NewUserRequest request) {
        return registrationService.addNewUser(request);
    }




}
