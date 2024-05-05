package shop.shoppingmall.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.shoppingmall.entity.Product;
import shop.shoppingmall.status.ProductStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private int price;

    private int stockQuantity;

    private String name;

    private String productMemo;

    private ProductStatus productStatus; //상품판매상태

    public static ProductDto entityToDto(Product product) {
        return ProductDto.builder()
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .name(product.getName())
                .productMemo(product.getProductMemo())
                .productStatus(ProductStatus.valueOf(product.getProductStatus().toString()))
                .build();
    }

}
