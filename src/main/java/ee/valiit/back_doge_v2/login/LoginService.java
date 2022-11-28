package ee.valiit.back_doge_v2.login;

import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;


    public LoginResponse login(String username, String password) {
        User user = userService.getValidUser(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;
    }
}
