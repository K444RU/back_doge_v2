package ee.valiit.back_doge_v2.domain.walker_information.walking_size;

import ee.valiit.back_doge_v2.domain.walker_information.size.Size;
import ee.valiit.back_doge_v2.domain.walker_information.walking.Walking;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "walking_size")
public class WalkingSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "walking_id", nullable = false)
    private Walking walking;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;

}