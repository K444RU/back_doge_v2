package ee.valiit.back_doge_v2.registration;

import ee.valiit.back_doge_v2.domain.user_role_information.contact.ContactDto;
import lombok.Data;

import java.util.List;

@Data
public class NewUserRegistration {
    private Integer contactid;
    private String username;
    private String password;
    private List<ContactDto> contact;



}
