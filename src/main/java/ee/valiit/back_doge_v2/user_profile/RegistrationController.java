package ee.valiit.back_doge_v2.user_profile;

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
    public void addNewUser(@RequestBody NewUserRequest request) {
        System.out.println();
        registrationService.addNewUser(request);

    }




}
