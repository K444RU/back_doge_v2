package ee.valiit.back_doge_v2.business.login.service;

import ee.valiit.back_doge_v2.business.login.dto.LoginResponse;
import ee.valiit.back_doge_v2.domain.user_role_information.role.Role;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.business.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;


    public LoginResponse login(String username, String password) {
        User user = userService.getValidUserByNameAndPassword(username, password);
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
