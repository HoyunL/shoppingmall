package shop.shoppingmall.status;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ProductStatus {

    ACTIVE("활성화"), INACTIVE("비활성화"), PENDING("보류");

    private String value;
}
