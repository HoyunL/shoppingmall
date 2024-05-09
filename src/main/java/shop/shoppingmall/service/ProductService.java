package shop.shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.shoppingmall.dto.ProductDto;
import shop.shoppingmall.entity.Product;
import shop.shoppingmall.repository.jpa.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Long addProduct(ProductDto productDto) {
        Product product = productRepository.save(Product.dtoToEntity(productDto));
        return product.getId();
    }

    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductDto::entityToDto)
                .collect(Collectors.toList());
    }

    public ProductDto findProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. ID: " + id));
        return ProductDto.entityToDto(product);
    }

    @Transactional
    public void updateProduct(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. ID: " + id));
        product.update(productDto);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
