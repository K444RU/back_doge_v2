package ee.valiit.back_doge_v2.registration;

import ee.valiit.back_doge_v2.domain.user_role_information.contact.Contact;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactRepository;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserRepository;
import ee.valiit.back_doge_v2.registration.NewUserRegistration;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegistrationService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private ContactRepository contactRepository;
    public void addNewUser(NewUserRegistration request) {
        User user = userMapper.toEntity(request);
        Contact contact = contactRepository.findById(request.getContactId()).get();
        user.setContact(contact);
        userRepository.save(user);




    }
}
