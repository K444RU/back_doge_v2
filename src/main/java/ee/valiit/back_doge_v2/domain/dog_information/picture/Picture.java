package ee.valiit.back_doge_v2.domain.dog_information.picture;

import ee.valiit.back_doge_v2.domain.dog_information.dog_picture.DogPicture;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "data")
    private byte[] data;

    @OneToMany(mappedBy = "picture")
    private Set<DogPicture> dogPictures = new LinkedHashSet<>();

}