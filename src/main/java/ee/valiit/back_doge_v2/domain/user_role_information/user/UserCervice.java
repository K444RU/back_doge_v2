package ee.valiit.back_doge_v2.domain.user_role_information.user;

import ee.valiit.back_doge_v2.errors.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserCervice {

    @Resource
    private UserRepository userRepository;

    public User getValidUser(String username, String password) {
        Optional<User> userLogin = userRepository.findBy(username, password);
        Validation.validationUser(userLogin);
        User user = userLogin.get();
        return user;
    }


}
