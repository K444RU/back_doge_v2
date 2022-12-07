package ee.valiit.back_doge_v2.domain.user_role_information.contact;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;

    public void save(Contact contact) {
        contactRepository.save(contact);
    }
}
