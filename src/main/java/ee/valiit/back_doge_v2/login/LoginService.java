package ee.valiit.back_doge_v2.login;

import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserCervice;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserCervice userCervice;


    public LoginResponse login(String username, String password) {
        User user = userCervice.getValidUser(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;
    }
}
