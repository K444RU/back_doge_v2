package ee.valiit.back_doge_v2.user_profile;

import ee.valiit.back_doge_v2.domain.user_role_information.contact.Contact;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactRepository;
import ee.valiit.back_doge_v2.domain.user_role_information.role.Role;
import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleRepository;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserRepository;
import ee.valiit.back_doge_v2.login.LoginResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegistrationService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private ContactRepository contactRepository;
    public LoginResponse addNewUser(NewUserRequest request)  {
        // TODO: valideeri, kas on olemas sama usernmae
        Contact contact = contactMapper.newUserRequestToContact(request);
        contactRepository.save(contact);
        Role role = roleRepository.findById(request.getRoleId()).get();
        User user = userMapper.newUserRequestToUser(request);
        user.setContact(contact);
        user.setRole(role);
        userRepository.save(user);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(user.getId());
        loginResponse.setRoleId(role.getId());
        loginResponse.setRoleType(role.getType());
        return loginResponse;


    }
}
