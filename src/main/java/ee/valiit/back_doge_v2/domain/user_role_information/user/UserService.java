package ee.valiit.back_doge_v2.domain.user_role_information.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
