package ee.valiit.back_doge_v2.business.register;

import ee.valiit.back_doge_v2.business.login.LoginResponse;
import ee.valiit.back_doge_v2.business.login.LoginService;
import ee.valiit.back_doge_v2.business.login.dto.RoleDto;
import ee.valiit.back_doge_v2.business.register.dto.NewUserRequest;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.Contact;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactService;
import ee.valiit.back_doge_v2.domain.user_role_information.role.Role;
import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleService;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserService;
import ee.valiit.back_doge_v2.errors.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegistrationService {

    @Resource
    private ContactService contactService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserService userService;

    @Resource
    private LoginService loginService;

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private UserMapper userMapper;


    public List<RoleDto> getAllRoles() {
        List<Role> all = roleService.findAllRoles();
        List<RoleDto> roleDtos = roleMapper.roleListToDtos(all);
        return roleDtos;
    }

    public LoginResponse addNewUser(NewUserRequest request) {
        boolean userExists = userService.userExists(request.getUsername());
        Validation.validateUserNameTaken(userExists);
        Contact contact = contactMapper.newUserRequestToContact(request);
        contactService.save(contact);
        Role role = roleService.findById(request.getRoleId()).get();
        User user = userMapper.newUserRequestToUser(request);
        user.setContact(contact);
        user.setRole(role);
        userService.save(user);
        return loginService.fromRegisterToLogin(role, user);
    }


}
