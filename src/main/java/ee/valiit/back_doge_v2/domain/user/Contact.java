package ee.valiit.back_doge_v2.domain.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(name = "e_mail", nullable = false, length = 30)
    private String eMail;

    @Size(max = 30)
    @NotNull
    @Column(name = "city", nullable = false, length = 30)
    private String city;

    @Size(max = 30)
    @NotNull
    @Column(name = "firstname", nullable = false, length = 30)
    private String firstname;

    @Size(max = 30)
    @NotNull
    @Column(name = "lastname", nullable = false, length = 30)
    private String lastname;

    @Size(max = 200)
    @Column(name = "adittion_information", length = 200)
    private String adittionInformation;

    @Column(name = "photo_data")
    private byte[] photoData;

}