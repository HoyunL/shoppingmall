package shop.shoppingmall.entity;

import jakarta.persistence.*;
import lombok.*;
import shop.shoppingmall.dto.ProductDto;
import shop.shoppingmall.status.ProductStatus;


@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_seq")
    private Long id;

    private int price;

    private int stockQuantity;

    private String name;

    private String productMemo;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus; //상품판매상태


    public static Product dtoToEntity(ProductDto productDto) {
        return Product.builder()
                .price(productDto.getPrice())
                .stockQuantity(productDto.getStockQuantity())
                .name(productDto.getName())
                .productMemo(productDto.getProductMemo())
                .productStatus(ProductStatus.valueOf(String.valueOf(productDto.getProductStatus())))
                .build();
    }

    public void update(ProductDto productDto) {
        this.price = productDto.getPrice();
        this.stockQuantity = productDto.getStockQuantity();
        this.name = productDto.getName();
        this.productMemo = productDto.getProductMemo();
        this.productStatus = productDto.getProductStatus();
    }
}
