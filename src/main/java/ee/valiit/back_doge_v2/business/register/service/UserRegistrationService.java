package ee.valiit.back_doge_v2.business.register.service;

import ee.valiit.back_doge_v2.business.login.service.LoginService;
import ee.valiit.back_doge_v2.business.register.dto.NewUserRequest;
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
import ee.valiit.back_doge_v2.business.login.dto.LoginResponse;
import ee.valiit.back_doge_v2.errors.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserRegistrationService {

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
        List<RoleDto> roleDtos = roleMapper.roleListToDtos(all);
        return roleDtos;
    }

    public LoginResponse addNewUser(NewUserRequest request) {
        Contact contact = contactMapper.newUserRequestToContact(request);
        contactRepository.save(contact);
        Role role = roleRepository.findById(request.getRoleId()).get();
        User user = userMapper.newUserRequestToUser(request);
        getValidUserByUsername(user);
        user.setContact(contact);
        user.setRole(role);
        userRepository.save(user);
        return loginService.fromRegisterToLogin(role, user);
    }

    private void getValidUserByUsername(User user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        Validation.validationUsername(optionalUser);
    }

}
