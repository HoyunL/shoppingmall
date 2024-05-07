package shop.shoppingmall.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum OrderStatus {

    ORDER("주문"), CANCEL("취소");

    private String value;
}
