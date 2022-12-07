package ee.valiit.back_doge_v2.business.login;

import ee.valiit.back_doge_v2.business.user.UsersService;
import ee.valiit.back_doge_v2.domain.user_role_information.role.Role;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UsersService usersService;

    public LoginResponse login(String username, String password) {
        User user = usersService.getValidUserBy(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;
    }

    public LoginResponse fromRegisterToLogin(Role role, User user) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(user.getId());
        loginResponse.setRoleId(role.getId());
        return loginResponse;
    }
}
