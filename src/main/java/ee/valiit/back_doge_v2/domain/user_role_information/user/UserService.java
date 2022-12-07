package ee.valiit.back_doge_v2.domain.user_role_information.user;

import ee.valiit.back_doge_v2.errors.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public boolean userExists(String username) {
        return userRepository.userExists(username);
    }

    public User findValidUserBy(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(username, password);
        Validation.validateCorrectCredentials(optionalUser);
        return optionalUser.get();
    }

    public User findById(Integer userId) {
        return userRepository.findById(userId).get();
    }
}
