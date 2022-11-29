package ee.valiit.back_doge_v2.business.register;

import ee.valiit.back_doge_v2.business.login.LoginService;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.Contact;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactRepository;
import ee.valiit.back_doge_v2.domain.user_role_information.role.Role;
import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleDto;
import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleRepository;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserRepository;
import ee.valiit.back_doge_v2.business.login.LoginResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegistrationService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRepository userRepository;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleRepository roleRepository;
    @Resource
    private ContactMapper contactMapper;
    @Resource
    private ContactRepository contactRepository;
    @Resource
    private LoginService loginService;

    public List<RoleDto> getAllRoles() {
        List<Role> all = roleRepository.findAll();
        List<RoleDto> roleDtos = roleMapper.toDtos(all);
        return roleDtos;
    }

    public LoginResponse addNewUser(NewUserRequest request) {
        // TODO: valideeri, kas on olemas sama usernmae
        Contact contact = contactMapper.newUserRequestToContact(request);
        contactRepository.save(contact);
        Role role = roleRepository.findById(request.getRoleId()).get();
        User user = userMapper.newUserRequestToUser(request);
        user.setContact(contact);
        user.setRole(role);
        userRepository.save(user);
        return loginService.fromRegisterToLogin(role, user);


    }

}
