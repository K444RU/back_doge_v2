package ee.valiit.back_doge_v2.registration;

import ee.valiit.back_doge_v2.domain.user_role_information.contact.Contact;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactRepository;
import ee.valiit.back_doge_v2.domain.user_role_information.role.Role;
import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.role.RoleRepository;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserDto;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class RegistrationService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private ContactRepository contactRepository;
    public void addNewUser(NewUserRequest request)  {
        Contact newUserContact = contactMapper.newUserRequestToContact(request);
        contactRepository.save(newUserContact);
        Optional<Role> optionalRole = roleRepository.findByType(request.getRole());
        if (optionalRole.isEmpty()) {
            System.out.println("Role not found");
        }
        Role newUserRole = optionalRole.get();
        UserDto userDto = new UserDto(request.getUsername(), request.getPassword(), newUserRole.getId(), newUserContact.getId());
        User user = userMapper.userDtoToUser(userDto);
        user.setContact(newUserContact);
        user.setRole(newUserRole);
        userRepository.save(user);






    }
}
