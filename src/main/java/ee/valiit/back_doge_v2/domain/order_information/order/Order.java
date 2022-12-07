package ee.valiit.back_doge_v2.domain.order_information.order;

import ee.valiit.back_doge_v2.domain.order_information.walking.Walking;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "walking_id", nullable = false)
    private Walking walking;

    @NotNull
    @Column(name = "walking_date", nullable = false)
    private LocalDate walkingDate;

    @NotNull
    @Column(name = "time_from", nullable = false)
    private LocalTime timeFrom;

    @NotNull
    @Column(name = "time_to", nullable = false)
    private LocalTime timeTo;

    @Size(max = 255)
    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;

}