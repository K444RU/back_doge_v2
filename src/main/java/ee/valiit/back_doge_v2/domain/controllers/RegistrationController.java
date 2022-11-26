package ee.valiit.back_doge_v2.domain.controllers;

import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.registration.NewUserRegistration;
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
    public void addNewUser(@RequestBody NewUserRegistration request) {
        System.out.println();
        registrationService.addNewUser(request);

    }


}
