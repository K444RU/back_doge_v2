package ee.valiit.back_doge_v2.domain.dog_information.dog;

import ee.valiit.back_doge_v2.domain.dog_information.breeds.Breed;
import ee.valiit.back_doge_v2.domain.dog_information.size.Size;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_user_id", nullable = false)
    private User ownerUser;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "breed_id", nullable = false)
    private Breed breed;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;

    @javax.validation.constraints.Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull
    @Column(name = "age", nullable = false)
    private Integer age;

    @javax.validation.constraints.Size(max = 300)
    @Column(name = "additional_information", length = 300)
    private String additionalInformation;

}