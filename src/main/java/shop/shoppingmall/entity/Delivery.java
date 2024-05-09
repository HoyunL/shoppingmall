package shop.shoppingmall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import shop.shoppingmall.etc.Address;
import shop.shoppingmall.status.DeliveryStatus;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //주의!! ORDINAL은 숫자로 들어가는데 중간에 새로 값이 추가되면 번호가 밀림
    private DeliveryStatus status; //READY, COMP
}
