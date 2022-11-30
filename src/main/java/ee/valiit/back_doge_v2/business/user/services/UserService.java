package ee.valiit.back_doge_v2.business.user.services;

import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactDto;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserRepository;
import ee.valiit.back_doge_v2.errors.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private ContactMapper contactMapper;

    public User getValidUser(String username, String password) {
        Optional<User> userLogin = userRepository.findBy(username, password);
        Validation.validationUser(userLogin);
        User result = userLogin.get();
        return result;
    }


//    public void getUserContactByUserId(Integer userId) {
//        Optional<User> byId = userRepository.findById(userId);
//        ContactDto contactDto = contactMapper.contactToContactDto(byId);
//
//    }
}
