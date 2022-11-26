package ee.valiit.back_doge_v2.registration;

import lombok.Data;

@Data
public class NewUserRegistration {
    private String contactId;
    private String firstname;
    private String lastname;
    private String eMail;
    private String city;
    private String username;
    private String password;
    private String additionalInformation;

}
