package ee.valiit.back_doge_v2.domain.order;

import ee.valiit.back_doge_v2.domain.walker.Walking;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "address", nullable = false)
    private Integer address;

    @NotNull
    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

}