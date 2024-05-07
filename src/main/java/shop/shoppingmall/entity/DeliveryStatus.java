package shop.shoppingmall.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum DeliveryStatus {

    READY("배송준비"), PROGRESS("배송중"), completed("배송완료");

    private String value;

}
