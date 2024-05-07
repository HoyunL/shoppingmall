package shop.shoppingmall.entity;

import jakarta.persistence.*;
import lombok.*;
import shop.shoppingmall.dto.ProductDto;
import shop.shoppingmall.status.ProductStatus;
import shop.shoppingmall.util.BaseTime;

import java.time.LocalDateTime;


@ToString
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private int price;

    private int stockQuantity;

    private String name;

    private String productMemo;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus; //상품판매상태

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

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
