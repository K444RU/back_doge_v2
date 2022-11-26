package ee.valiit.back_doge_v2.domain.controllers;

import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.registration.NewUserRegistration;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegistrationService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ContactMapper contactMapper;
    public void addNewUser(NewUserRegistration request) {
        User user = userMapper.toEntity(request);


    }
}
